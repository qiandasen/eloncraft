package org.sdoaj.eloncraft.blocks.machines.workbench;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import org.sdoaj.eloncraft.blocks.ModBlocks;
import org.sdoaj.eloncraft.recipes.RecipeKey;
import org.sdoaj.eloncraft.items.ModItems;

import java.util.ArrayList;
import java.util.List;

public final class WorkbenchRecipes {
    private static final List<WorkbenchRecipe> recipes = new ArrayList<>();

    public static void addRecipe(WorkbenchRecipe recipe) {
        recipes.add(recipe);
    }

    public static WorkbenchRecipe getRecipeFromInput(ItemStack[][] input) {
        for (WorkbenchRecipe recipe : recipes) {
            if (recipe.matches(input)) {
                return recipe;
            }
        }

        return null;
    }

    public static void init() {
        addRecipe(new WorkbenchRecipe(new String[]{
                "ttttt",
                "tPPPt",
                "tbbbt",
                "t p t",
                "BBBBB"
        }, new ItemStack(ModBlocks.METAL_ROLLER),
                new RecipeKey('t', "ingotTitanium"),
                new RecipeKey('P', Blocks.STICKY_PISTON),
                new RecipeKey('b', Blocks.IRON_BLOCK),
                new RecipeKey('B', Blocks.OBSIDIAN),
                new RecipeKey('p', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "ttttt",
                "tPfPt",
                "tf ft",
                "tPfPt",
                "BBBBB"
        }, new ItemStack(ModBlocks.CRUSHER),
                new RecipeKey('t', "ingotTitanium"),
                new RecipeKey('f', Items.FLINT),
                new RecipeKey('P', Blocks.PISTON),
                new RecipeKey('B', Blocks.OBSIDIAN)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "cst   tsc",
                "cst   tsc",
                "cst   tsc",
                "cst   tsc",
                "cst   tsc",
                "TstttttsT",
                "TsssssssT",
                "TTTTTTTTT"
        }, new ItemStack(ModBlocks.ALLOY_FURNACE),
                new RecipeKey('t', Blocks.HARDENED_CLAY),
                new RecipeKey('s', "plateSteel"),
                new RecipeKey('c', "plateCopper"),
                new RecipeKey('T', "plateTitanium")));

        addRecipe(new WorkbenchRecipe(new String[]{
                "ttttttt",
                "ttssstt",
                "ts   st",
                "ts   st",
                "ts   st",
                "ts   st",
                "ts   st",
                "ts   st",
                "ts   st",
                "ttsssff",
                "tttttff"
        }, new ItemStack(ModBlocks.REFINERY),
                new RecipeKey('s', "plateSteel"),
                new RecipeKey('t', "plateTitanium"),
                new RecipeKey('f', Blocks.FURNACE)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "ttttttt",
                "tiiiiit",
                "ticccit",
                "ticiiit",
                "ticccit",
                "tiiicit",
                "ticccit",
                "tiiiiit",
                "ttttttt"
        }, new ItemStack(ModBlocks.LOX_COLLECTOR),
                new RecipeKey('t', "plateTitanium"),
                new RecipeKey('c', "nuggetCopper"),
                new RecipeKey('i', Blocks.PACKED_ICE)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "ttttttt",
                "tiiiiit",
                "ticccit",
                "tiiicit",
                "ticccit",
                "ticiiit",
                "ticccit",
                "tiiiiit",
                "ttttttt"
        }, new ItemStack(ModBlocks.LOX_COLLECTOR),
                new RecipeKey('t', "plateTitanium"),
                new RecipeKey('c', "nuggetCopper"),
                new RecipeKey('i', Blocks.PACKED_ICE)));



        addRecipe(new WorkbenchRecipe(new String[]{
                "p p p",
                " ppp ",
                "pptpp",
                " ppp ",
                "p p p"
        }, new ItemStack(ModItems.TITANIUM_FAN),
                new RecipeKey('t', "ingotTitanium"),
                new RecipeKey('p', "plateTitanium")));



        addRecipe(new WorkbenchRecipe(new String[]{
                "  tcr     ",
                "  nnn     ",
                " n   pPp  ",
                " n   n I  ",
                " n   nPp  ",
                "  n n p   ",
                "  n n pAAA",
                " n   n pPA",
                "ppppppppIA",
                "n     n   ",
                "n     n   ",
                "n     n   "
        }, new ItemStack(ModItems.MERLIN_ENGINE),
                new RecipeKey('n', ModItems.NIOBIUM_C103_PLATE),
                new RecipeKey('p', ModItems.FUEL_PIPE),
                new RecipeKey('P', ModItems.TITANIUM_FAN),
                new RecipeKey('A', ModItems.ALUMINUM_2198_PLATE),
                new RecipeKey('I', ModItems.INCONEL_PLATE),
                new RecipeKey('t', Blocks.REDSTONE_TORCH),
                new RecipeKey('c', Items.COMPARATOR),
                new RecipeKey('r', Items.REPEATER)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "    ppppp    ",
                "  ppppppppp  ",
                " pppppeppppp ",
                " ppepppppepp ",
                "ppppppppppppp",
                "ppppppppppppp",
                "ppepppepppepp",
                "ppppppppppppp",
                "ppppppppppppp",
                " ppepppppepp ",
                " pppppeppppp ",
                "  ppppppppp  ",
                "    ppppp    "
        }, new ItemStack(ModItems.OCTAWEB),
                new RecipeKey('p', ModItems.ALUMINUM_7XXX_PLATE),
                new RecipeKey('e', ModItems.MERLIN_ENGINE)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "ccc        ",
                "caPa       ",
                "cac ac     ",
                "cac cac    ",
                "cac  cac   ",
                "cac   cac  ",
                "cac    cac ",
                "ccc     ccc"
        }, new ItemStack(ModItems.LANDING_LEG),
                new RecipeKey('c', ModItems.CARBON_FIBER_PLATE),
                new RecipeKey('a', "plateAluminum"),
                new RecipeKey('P', Blocks.PISTON)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "p ppppp p",
                "ppp   ppp",
                "pp     pp",
                "pp     pp",
                "pp     pp",
                "pp     pp",
                "pp     pp",
                "pp     pp",
                "pp     pp",
                "pp     pp",
                "ppp   ppp",
                "p ppppp p"
        }, new ItemStack(ModItems.FUEL_TANK_LOX_1),
                new RecipeKey('p', ModItems.ALUMINUM_2198_PLATE)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "p pppPp p",
                "ppp  Pppp",
                "pp   P pp",
                "pp   P pp",
                "pp   P pp",
                "pp   P pp",
                "pp  P  pp",
                "pp  P  pp",
                "pp  P  pp",
                "pp  P  pp",
                "ppp P ppp",
                "p ppPpp p"
        }, new ItemStack(ModItems.FUEL_TANK_RP1_1),
                new RecipeKey('p', ModItems.ALUMINUM_2198_PLATE),
                new RecipeKey('P', ModItems.FUEL_PIPE)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "  ipi  ",
                " iiiii ",
                "ip p pi",
                "i p p i",
                "ip p pi",
                "i p p i",
                "iiiiiii",
        }, new ItemStack(ModItems.GRID_FIN, 2),
                new RecipeKey('i', "ingotTitanium"),
                new RecipeKey('p', "ingotTitanium")));

        addRecipe(new WorkbenchRecipe(new String[]{
                "  ipi ",
                " iiiii",
                "i p p i",
                "ip p pi",
                "i p p i",
                "ip p pi",
                "iiiiiii",
        }, new ItemStack(ModItems.GRID_FIN, 2),
                new RecipeKey('i', "ingotTitanium"),
                new RecipeKey('p', "ingotTitanium")));

        addRecipe(new WorkbenchRecipe(new String[]{
                " ppp ",
                "ppppp",
                "PpPpP",
                "ppppp",
        }, new ItemStack(ModItems.COLD_GAS_THRUSTER, 1),
                new RecipeKey('p', ModItems.ALUMINUM_2198_PLATE),
                new RecipeKey('P', Blocks.PISTON)));

        addRecipe(new WorkbenchRecipe(new String[]{
                " cp     pc ",
                " cp     pc ",
                " cp     pc ",
                " cp     pc ",
                "fcpP t Ppcf",
                "fcpP t Ppcf"
        }, new ItemStack(ModItems.INTERSTAGE),
                new RecipeKey('p', ModItems.ALUMINUM_2198_PLATE),
                new RecipeKey('c', ModItems.CARBON_FIBER_PLATE),
                new RecipeKey('P', Blocks.PISTON),
                new RecipeKey('f', ModItems.GRID_FIN),
                new RecipeKey('t', ModItems.COLD_GAS_THRUSTER)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "p ppppp p",
                "ppp   ppp",
                "pp     pp",
                "pp     pp",
                "ppp   ppp",
                "p ppppp p"
        }, new ItemStack(ModItems.FUEL_TANK_LOX_2),
                new RecipeKey('p', ModItems.ALUMINUM_2198_PLATE)));

        addRecipe(new WorkbenchRecipe(new String[]{
                "p pppPp p",
                "ppp  Pppp",
                "pp   P pp",
                "pp  P  pp",
                "ppp P ppp",
                "p ppPpp p"
        }, new ItemStack(ModItems.FUEL_TANK_RP1_2),
                new RecipeKey('p', ModItems.ALUMINUM_2198_PLATE),
                new RecipeKey('P', ModItems.FUEL_PIPE)));



        addRecipe(new WorkbenchRecipe(new String[]{
                "bbbbbbbrrrrrr",
                "bsbsbsbwwwwww",
                "bbsbsbbrrrrrr",
                "bsbsbsbwwwwww",
                "bbsbsbbrrrrrr",
                "bsbsbsbwwwwww",
                "bbbbbbbrrrrrr",
                "wwwwwwwwwwwww",
                "rrrrrrrrrrrrr",
                "wwwwwwwwwwwww",
                "rrrrrrrrrrrrr",
                "wwwwwwwwwwwww",
                "rrrrrrrrrrrrr"
        }, new ItemStack(ModItems.USA_FLAG),
                new RecipeKey('r', Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, 14))),
                new RecipeKey('w', Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, 0))),
                new RecipeKey('b', Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, 11))),
                new RecipeKey('s', Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, 0)))));

        addRecipe(new WorkbenchRecipe(new String[]{
                "bbbbbbbrrrrrr",
                "bsbsbsbwwwwww",
                "bbsbsbbrrrrrr",
                "bsbsbsbwwwwww",
                "bbsbsbbrrrrrr",
                "bsbsbsbwwwwww",
                "bbbbbbFrrrrrr",
                "wwwwwwwwwwwww",
                "rrrrrrrrrrrrr",
                "wwwwwwwwwwwww",
                "rrrrrrrrrrrrr",
                "wwwwwwwwwwwww",
                "rrrrrrrrrrrrr"
        }, new ItemStack(ModItems.USA_FLAG_EPIC),
                new RecipeKey('r', Blocks.NETHER_WART_BLOCK),
                new RecipeKey('w', Blocks.SEA_LANTERN),
                new RecipeKey('b', Blocks.DIAMOND_BLOCK),
                new RecipeKey('s', Items.NETHER_STAR),
                new RecipeKey('F', ModItems.USA_FLAG)));



        addRecipe(new WorkbenchRecipe(new String[] {
                "iiiii",
                "i   i",
                " i i ",
                "i   i",
                "i   i",
                "i   i",
                " i i ",
                "i   i",
                "i   i"
        }, new ItemStack(ModItems.SUPERDRACO_ENGINE, 2),
                new RecipeKey('i', ModItems.INCONEL_PLATE)));

        addRecipe(new WorkbenchRecipe(new String[] {
                " ttt ",
                "tt tt",
                "t   t",
                "tt tt",
                " ttt "
        }, new ItemStack(ModItems.FUEL_TANK_3),
                new RecipeKey('t', "plateTitanium")));

        addRecipe(new WorkbenchRecipe(new String[] {
                "  sds  ",
                " gsssg ",
                " gsssg ",
                "eesssee",
                "eesssee",
                "sssssss",
                "sssssss",
                "sssssss",
                "sssssss",
                "sssssss",
        }, new ItemStack(ModItems.FALCON9_DRAGON),
                new RecipeKey('s', ModItems.HEAT_SHIELD),
                new RecipeKey('g', new ItemStack(Blocks.STAINED_GLASS_PANE, 1, 15)),
                new RecipeKey('e', ModItems.SUPERDRACO_ENGINE),
                new RecipeKey('d', Blocks.DRAGON_EGG)));



        addRecipe(new WorkbenchRecipe(new String[]{
                " d ",
                " s ",
                " S ",
                " e ",
                " i ",
                " t ",
                "lTl",
                "lwl"
        }, new ItemStack(ModItems.FALCON9),
                new RecipeKey('w', ModItems.OCTAWEB),
                new RecipeKey('l', ModItems.LANDING_LEG),
                new RecipeKey('T', ModItems.FUEL_TANK_RP1_1),
                new RecipeKey('t', ModItems.FUEL_TANK_LOX_1),
                new RecipeKey('i', ModItems.INTERSTAGE),
                new RecipeKey('e', ModItems.MERLIN_ENGINE),
                new RecipeKey('S', ModItems.FUEL_TANK_RP1_2),
                new RecipeKey('s', ModItems.FUEL_TANK_LOX_2),
                new RecipeKey('d', ModItems.FALCON9_DRAGON)));



        addRecipe(new WorkbenchRecipe(new String[]{
                "ccccccc",
                "ccccccc"
        }, new ItemStack(ModBlocks.LAUNCHPAD, 7),
                new RecipeKey('c', new ItemStack(Blocks.CONCRETE, 1, 8))));

        addRecipe(new WorkbenchRecipe(new String[]{
                "ttttttttt",
                "taaaaablt",
                "ta a allt",
                "ta a albt",
                "ta a ablt",
                "ta a albt",
                "ta a abbt",
                "taaaaallt",
                "ttttttttt"
        }, new ItemStack(ModBlocks.LAUNCH_CONTROLLER, 1),
                new RecipeKey('t', "plateTitanium"),
                new RecipeKey('a', "plateAluminum"),
                new RecipeKey('l', Blocks.LEVER),
                new RecipeKey('b', Blocks.STONE_BUTTON)));
    }
}