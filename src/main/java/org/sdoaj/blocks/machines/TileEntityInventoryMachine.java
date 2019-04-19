package org.sdoaj.blocks.machines;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.IEnergyStorage;
import org.sdoaj.blocks.machines.alloyfurnace.BlockAlloyFurnace;
import org.sdoaj.blocks.tileentities.CustomEnergyStorage;
import org.sdoaj.blocks.tileentities.TileEntityInventoryBase;

public abstract class TileEntityInventoryMachine extends TileEntityInventoryBase {
    protected final int maxProcessTime;
    protected final int energyPerOperation;
    protected int processTime;
    protected int lastProcess;
    protected boolean lastProcessed;

    protected final CustomEnergyStorage energyStorage;
    protected int lastEnergy;

    protected final PropertyBool IS_ON;

    public TileEntityInventoryMachine(String name, int slots, int maxProcessTime, int energyPerOperation,
                                      CustomEnergyStorage energyStorage, PropertyBool on) {
        super(name, slots);
        this.maxProcessTime = maxProcessTime;
        this.energyPerOperation = energyPerOperation;

        this.energyStorage = energyStorage;

        this.IS_ON = on;
    }

    @Override
    public void writeSyncableNBT(NBTTagCompound compound, NBTType type) {
        if (type != NBTType.SAVE_BLOCK) {
            compound.setInteger("ProcessTime", this.processTime);
        }

        this.energyStorage.writeToNBT(compound);
        super.writeSyncableNBT(compound, type);
    }

    @Override
    public void readSyncableNBT(NBTTagCompound compound, NBTType type) {
        if (type != NBTType.SAVE_BLOCK) {
            this.processTime = compound.getInteger("ProcessTime");
        }

        this.energyStorage.readFromNBT(compound);
        super.readSyncableNBT(compound, type);
    }

    protected boolean hasChanged() {
        return this.lastProcess != this.processTime || this.lastEnergy != this.energyStorage.getEnergyStored();
    }

    protected void updatePreviousValues() {
        this.lastProcess = this.processTime;
        this.lastEnergy = this.energyStorage.getEnergyStored();
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (this.world.isRemote) {
            return;
        }

        boolean processed = false;
        boolean canProcess = this.canProcess();

        if (canProcess) {
            if (this.energyStorage.getEnergyStored() >= getEnergyPerTick()) {
                this.processTime++;
                if (this.processTime >= this.getMaxProcessTime()) {
                    this.finishProcessing();
                    this.processTime = 0;
                }
                this.energyStorage.extractEnergyInternal(getEnergyPerTick(), false);
            }

            processed = this.energyStorage.getEnergyStored() >= getEnergyPerTick();
        } else {
            this.processTime = 0;
        }

        IBlockState currentState = this.world.getBlockState(this.pos);
        boolean current = currentState.getValue(BlockAlloyFurnace.IS_ON);
        boolean changeTo = current;
        if (lastProcessed != processed) {
            changeTo = processed;
        }
        if (this.isRedstonePowered) {
            changeTo = true;
        }
        if (!processed && !this.isRedstonePowered) {
            changeTo = false;
        }

        if (changeTo != current) {
            world.setBlockState(this.pos, currentState.withProperty(IS_ON, changeTo));
        }

        this.lastProcessed = processed;

        if (this.hasChanged() && this.sendUpdateWithInterval()) {
            this.updatePreviousValues();
            this.markChanged();
        }
    }

    public abstract boolean canProcess();

    public abstract void finishProcessing();

    public void reset() {
        this.processTime = 0;
        this.lastProcess = 0;
    }

    public boolean guiShowProgress() {
        return processTime > 0;
    }

    protected int getMaxProcessTime() {
        return maxProcessTime;
    }

    protected int getEnergyPerOperation() {
        return energyPerOperation;
    }

    protected int getEnergyPerTick() {
        return getEnergyPerOperation() / getMaxProcessTime();
    }

    @Override
    public IEnergyStorage getEnergyStorage(EnumFacing facing) {
        return energyStorage;
    }

    public CustomEnergyStorage getCustomEnergyStorage() {
        return energyStorage;
    }

    public int getTimeScaled(int i) {
        return this.processTime * i / this.getMaxProcessTime();
    }
}