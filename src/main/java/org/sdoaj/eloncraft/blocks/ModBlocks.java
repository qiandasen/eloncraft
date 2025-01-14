package org.sdoaj.eloncraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.sdoaj.eloncraft.blocks.launch.BlockLaunchpad;
import org.sdoaj.eloncraft.blocks.launch.controller.BlockLaunchController;
import org.sdoaj.eloncraft.blocks.machines.alloyfurnace.BlockAlloyFurnace;
import org.sdoaj.eloncraft.blocks.machines.crusher.BlockCrusher;
import org.sdoaj.eloncraft.blocks.machines.loxcollector.BlockLOXCollector;
import org.sdoaj.eloncraft.blocks.machines.metalroller.BlockMetalRoller;
import org.sdoaj.eloncraft.blocks.machines.refinery.BlockRefinery;
import org.sdoaj.eloncraft.blocks.machines.workbench.BlockWorkbench;
import org.sdoaj.eloncraft.Eloncraft;
import org.sdoaj.eloncraft.items.ModCreativeTabs;
import org.sdoaj.eloncraft.items.ModItems;
import org.sdoaj.eloncraft.items.util.Drop;
import org.sdoaj.eloncraft.items.util.Drops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mod.EventBusSubscriber(modid = Eloncraft.MODID)
public class ModBlocks {
    private static final List<Block> blocks = new ArrayList<>();
    private static final HashMap<Block, String> oreDictEntries = new HashMap<>();

    public static Block COMPONENTS;

    public static Block ALUMINUM_ORE;
    public static Block TITANIUM_ORE;
    public static Block LITHIUM_ORE;
    public static Block NICKEL_ORE;
    public static Block CHROMIUM_ORE;
    public static Block COPPER_ORE;
    public static Block NIOBIUM_ORE;
    public static Block HAFNIUM_ORE;
    public static Block MAGNESIUM_ORE;
    public static Block ZINC_ORE;

    public static BlockWorkbench ELON_WORKBENCH;

    public static BlockMetalRoller METAL_ROLLER;
    public static BlockCrusher CRUSHER;
    public static BlockAlloyFurnace ALLOY_FURNACE;
    public static BlockRefinery REFINERY;
    public static BlockLOXCollector LOX_COLLECTOR;

    public static BlockLaunchController LAUNCH_CONTROLLER;
    public static Block LAUNCHPAD;

    public static void init() {
        COMPONENTS = new BlockOre("components", Material.IRON, new Drops(
                new Drop(ModItems.BROKEN_STEEL_GEAR, 2, 3, 1),
                new Drop(ModItems.DAMAGED_AIRCRAFT_PLATING, 0, 1, 0.5),
                new Drop(ModItems.COPPER_NUGGET, 3, 5, 2),
                new Drop(ModItems.LITHIUM_NUGGET, 1, 3, 1.5),
                new Drop(Items.IRON_NUGGET, 2, 4, 2)))
                .setHardness(5.0F).setResistance(10.0F);
        COMPONENTS.setHarvestLevel("pickaxe", 2);

        ALUMINUM_ORE = BlockOre.newStoneOre("aluminum", 2, 3, 5);
        TITANIUM_ORE = BlockOre.newStoneOre("titanium", 3, 7, 20);
        LITHIUM_ORE = BlockOre.newStoneOre("lithium", 2, 3, 5);
        NICKEL_ORE = BlockOre.newStoneOre("nickel", 2, 5, 10);
        CHROMIUM_ORE = BlockOre.newStoneOre("chromium", 2, 3, 5);
        COPPER_ORE = BlockOre.newStoneOre("copper", 2, 3, 5);
        NIOBIUM_ORE = BlockOre.newStoneOre("niobium", 3, 4, 8);
        HAFNIUM_ORE = BlockOre.newStoneOre("hafnium", 3, 4, 8);
        MAGNESIUM_ORE = BlockOre.newStoneOre("magnesium", 2, 3, 5);
        ZINC_ORE = BlockOre.newStoneOre("zinc", 2, 3, 5);

        ELON_WORKBENCH = new BlockWorkbench("elon_workbench", Material.IRON);
        ELON_WORKBENCH.setHardness(10.0F).setResistance(25.0F).setHarvestLevel("pickaxe", 3);

        METAL_ROLLER = new BlockMetalRoller("metal_roller", Material.IRON);
        METAL_ROLLER.setHardness(10.0F).setResistance(25.0F).setHarvestLevel("pickaxe", 3);
        METAL_ROLLER.setHarvestLevel("pickaxe", 2);
        CRUSHER = new BlockCrusher("crusher", Material.IRON);
        CRUSHER.setHardness(10.0F).setResistance(25.0F).setHarvestLevel("pickaxe", 3);
        CRUSHER.addLore("Pulverizer, SAG Mill, etc. - whatever you want to call it.");
        CRUSHER.setHarvestLevel("pickaxe", 2);
        ALLOY_FURNACE = new BlockAlloyFurnace("alloy_furnace", Material.IRON);
        ALLOY_FURNACE.setHardness(20.0F).setResistance(40.0F).setHarvestLevel("pickaxe", 3);
        ALLOY_FURNACE.addLore("A somewhat unrealistic alloy furnace that can also serve as a blast furnace.");
        ALLOY_FURNACE.setHarvestLevel("pickaxe", 2);
        REFINERY = new BlockRefinery("refinery", Material.IRON);
        REFINERY.addLore("Used to refine petroleum oil into rocket fuel (which can't melt steel beams).");
        REFINERY.setHarvestLevel("pickaxe", 2);
        LOX_COLLECTOR = new BlockLOXCollector("lox_collector", Material.IRON);
        LOX_COLLECTOR.addLore("Condenses and purifies air into pure liquid oxygen.");
        LOX_COLLECTOR.setHarvestLevel("pickaxe", 2);

        LAUNCH_CONTROLLER = new BlockLaunchController("launch_controller", Material.IRON);
        LAUNCH_CONTROLLER.setHardness(20.0F).setResistance(50.0F).setHarvestLevel("pickaxe", 2);
        LAUNCH_CONTROLLER.addLore("Used to load fuel into rockets and initiate launch sequences.");
        LAUNCH_CONTROLLER.setCreativeTab(ModCreativeTabs.SPACEX);
        LAUNCHPAD = new BlockLaunchpad("launchpad", Material.IRON);
        LAUNCHPAD.setHardness(5.0F).setResistance(10.0F).setHarvestLevel("pickaxe", 2);
        LAUNCHPAD.setCreativeTab(ModCreativeTabs.SPACEX);
    }

    public static void addBlock(Block block) {
        blocks.add(block);
    }

    static void setOreDictName(Block block, String name) {
        oreDictEntries.put(block, name);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        blocks.forEach(registry::register);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        blocks.forEach(block -> {
            ItemBlock itemBlock = new ItemBlock(block);

            if (block instanceof BlockBasic) {
                itemBlock = ((BlockBasic) block).getItemBlock();
            }

            registry.register(itemBlock.setRegistryName(block.getRegistryName()));
        });

        oreDictEntries.keySet().forEach(block -> OreDictionary.registerOre(oreDictEntries.get(block), block));
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        blocks.forEach(block -> registerRender(Item.getItemFromBlock(block)));
    }
}
