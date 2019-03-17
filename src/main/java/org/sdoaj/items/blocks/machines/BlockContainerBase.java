/*
 * This file ("BlockContainerBase.java") is part of the Actually Additions mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://ellpeck.de/actaddlicense
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * © 2015-2017 Ellpeck
 */

package org.sdoaj.items.blocks.machines;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import org.sdoaj.eloncraft.Main;
import org.sdoaj.items.blocks.ModBlocks;
import org.sdoaj.util.StackUtil;
import org.sdoaj.util.WorldUtil;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BlockContainerBase extends BlockContainer {
    private final String name;

    public BlockContainerBase(String name, Material material) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        ModBlocks.addBlock(this);
    }

    protected String getBaseName() {
        return this.name;
    }

    private void dropInventory(World world, BlockPos position) {
        if (!world.isRemote) {
            TileEntity aTile = world.getTileEntity(position);
            if (aTile instanceof TileEntityInventoryBase) {
                TileEntityInventoryBase tile = (TileEntityInventoryBase) aTile;
                if (tile.inv.getSlots() > 0) {
                    for (int i = 0; i < tile.inv.getSlots(); i++) {
                        this.dropSlotFromInventory(i, tile, world, position);
                    }
                }
            }
        }
    }

    private void dropSlotFromInventory(int i, TileEntityInventoryBase tile, World world, BlockPos pos) {
        ItemStack stack = tile.inv.getStackInSlot(i);
        if (StackUtil.isValid(stack)) {
            float dX = world.rand.nextFloat() * 0.8F + 0.1F;
            float dY = world.rand.nextFloat() * 0.8F + 0.1F;
            float dZ = world.rand.nextFloat() * 0.8F + 0.1F;
            EntityItem entityItem = new EntityItem(world, pos.getX() + dX, pos.getY() + dY, pos.getZ() + dZ, stack.copy());
            float factor = 0.05F;
            entityItem.motionX = world.rand.nextGaussian() * factor;
            entityItem.motionY = world.rand.nextGaussian() * factor + 0.2F;
            entityItem.motionZ = world.rand.nextGaussian() * factor;
            world.spawnEntity(entityItem);
        }
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileEntityBase) {
                TileEntityBase base = (TileEntityBase) tile;
                if (base.respondsToPulses()) {
                    base.activateOnPulse();
                }
            }
        }
    }

    public void neighborsChangedCustom(World world, BlockPos pos) {
        this.updateRedstoneState(world, pos);

        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileEntityBase) {
            TileEntityBase base = (TileEntityBase) tile;
            if (base.shouldSaveDataOnChangeOrWorldStart()) {
                base.saveDataOnChangeOrWorldStart();
            }
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos otherPos) {
        this.neighborsChangedCustom(worldIn, pos);
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(world, pos, neighbor);
        if (world instanceof World) {
            this.neighborsChangedCustom((World) world, pos);
        }
    }

    public void updateRedstoneState(World world, BlockPos pos) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileEntityBase) {
                TileEntityBase base = (TileEntityBase) tile;
                boolean powered = WorldUtil.getRedstonePowerFromNeighbors(world, pos) > 0;
                boolean wasPowered = base.isRedstonePowered;
                if (powered && !wasPowered) {
                    if (base.respondsToPulses()) {
                        world.scheduleUpdate(pos, this, this.tickRate(world));
                    }
                    base.setRedstonePowered(true);
                } else if (!powered && wasPowered) {
                    base.setRedstonePowered(false);
                }
            }
        }
    }

    protected boolean tryUseItemOnTank(EntityPlayer player, EnumHand hand, FluidTank tank) {
        ItemStack heldItem = player.getHeldItem(hand);
        return StackUtil.isValid(heldItem) && FluidUtil.interactWithFluidHandler(player, hand, tank);

    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        this.updateRedstoneState(world, pos);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        if (stack.hasTagCompound()) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileEntityBase) {
                TileEntityBase base = (TileEntityBase) tile;
                NBTTagCompound compound = stack.getTagCompound().getCompoundTag("Data");
                if (compound != null) {
                    base.readSyncableNBT(compound, TileEntityBase.NBTType.SAVE_BLOCK);
                }
            }
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileEntityBase && ((TileEntityBase) tile).stopFromDropping) {
                player.sendMessage(new TextComponentTranslation("info." + Main.MODID + ".machineBroke").setStyle(new Style().setColor(TextFormatting.RED)));
            }
        }
    }

    @Override
    public boolean hasComparatorInputOverride(IBlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(IBlockState state, World world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileEntityBase) {
            return ((TileEntityBase) tile).getComparatorStrength();
        }
        return 0;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileEntityBase) {
            TileEntityBase base = (TileEntityBase) tile;
            if (!base.stopFromDropping) {
                NBTTagCompound data = new NBTTagCompound();
                base.writeSyncableNBT(data, TileEntityBase.NBTType.SAVE_BLOCK);

                //Remove unnecessarily saved default values to avoid unstackability
                List<String> keysToRemove = new ArrayList<>();
                for (String key : data.getKeySet()) {
                    NBTBase tag = data.getTag(key);
                    //Remove only ints because they are the most common ones
                    //Add else if below here to remove more types
                    if (tag instanceof NBTTagInt) {
                        if (((NBTTagInt) tag).getInt() == 0) {
                            keysToRemove.add(key);
                        }
                    }
                }
                for (String key : keysToRemove) {
                    data.removeTag(key);
                }

                ItemStack stack = new ItemStack(this.getItemDropped(state, tile.getWorld().rand, fortune), 1, this.damageDropped(state));
                if (!data.hasNoTags()) {
                    stack.setTagCompound(new NBTTagCompound());
                    stack.getTagCompound().setTag("Data", data);
                }

                drops.add(stack);
            }
        } else {
            super.getDrops(drops, world, pos, state, fortune);
        }
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        return willHarvest || super.removedByPlayer(state, world, pos, player, false);
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
        worldIn.setBlockToAir(pos);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        if (this.shouldDropInventory(world, pos)) {
            this.dropInventory(world, pos);
        }

        super.breakBlock(world, pos, state);
    }

    public boolean shouldDropInventory(World world, BlockPos pos) {
        return true;
    }
}