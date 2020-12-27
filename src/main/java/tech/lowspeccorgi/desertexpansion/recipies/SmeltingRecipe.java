package tech.lowspeccorgi.desertexpansion.recipies;

import net.minecraft.item.ItemStack;

public class SmeltingRecipe
{
    public Object input;
    public ItemStack output;
    public float xp;

    public SmeltingRecipe(Object input, ItemStack output, float xp)
    {
        this.input = input;
        this.output = output;
        this.xp = xp;
        ModRecipes.SMELTING_RECIPES.add(this);
    }
}
