package org.sdoaj.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.sdoaj.items.ModCreativeTabs;
import org.sdoaj.items.items.ItemBasic;

import java.util.ArrayList;
import java.util.List;

public class BlockBasic extends Block {
    private int burnTime = -1;

    public BlockBasic(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        ModBlocks.addBlock(this);
        setCreativeTab(ModCreativeTabs.ELONCRAFT);
    }

    private final List<String> lore = new ArrayList<>();

    public void addLore(String lore) {
        this.lore.add(lore);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        tooltip.addAll(lore);
    }

    public void setBurnTime(int burnTime) {
        this.burnTime = burnTime;
    }

    public ItemBlockBasic getItemBlock() {
        return new ItemBlockBasic(this);
    }

    public static class ItemBlockBasic extends ItemBlock {
        private final BlockBasic block;

        private ItemBlockBasic(BlockBasic block) {
            super(block);
            this.block = block;
        }

        @Override
        public int getItemBurnTime(ItemStack itemStack) {
            return block.burnTime;
        }
    }
}