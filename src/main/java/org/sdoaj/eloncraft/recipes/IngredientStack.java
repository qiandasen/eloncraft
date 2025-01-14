package org.sdoaj.eloncraft.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Arrays;

public class IngredientStack {
    private final Ingredient ingredient;
    private int count;

    public IngredientStack(Ingredient ingredient, int count) {
        this.ingredient = ingredient;
        this.count = count;
    }

    public IngredientStack(IngredientStack other) {
        this(other.ingredient, other.count);
    }

    public IngredientStack(ItemStack stack) {
        this(Ingredient.fromStacks(stack), stack.getCount());
    }

    public IngredientStack(Item item, int count) {
        this(new ItemStack(item, count));
    }

    public IngredientStack(Item item) {
        this(item, 1);
    }

    public IngredientStack(Block block, int count) {
        this(new ItemStack(block, count));
    }

    public IngredientStack(Block block) {
        this(block, 1);
    }

    public IngredientStack(int count, String... oreDictNames) {
        this(Ingredient.fromStacks(Arrays.stream(oreDictNames).map(OreDictionary::getOres).
                flatMap(NonNullList::stream).toArray(ItemStack[]::new)), count);
    }

    public boolean apply(ItemStack stack) {
        return ingredient.apply(stack) && stack.getCount() >= count;
    }

    public boolean applyIgnoreCount(ItemStack stack) {
        return ingredient.apply(stack);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int grow(int amount) {
        this.count += amount;
        return this.count;
    }

    public int shrink(int amount) {
        this.count -= amount;
        return this.count;
    }

    @Override
    public String toString() {
        return count + "x " + ingredient.toString();
    }
}
