package tech.lowspeccorgi.desertexpansion.recipies;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;
import tech.lowspeccorgi.desertexpansion.blocks.ModBlocks;
import tech.lowspeccorgi.desertexpansion.items.ModItems;

import java.util.ArrayList;

public class ModRecipes {
    public static ArrayList<SmeltingRecipe> SMELTING_RECIPES = new ArrayList<SmeltingRecipe>();

    /* Add recipies here */
    public static final SmeltingRecipe hardenedSandRecipe = new SmeltingRecipe(
            ModBlocks.hardenedSand, new ItemStack(ModItems.hardenedSandIngot, 1), 1.0f);

    public static void init() {
        SMELTING_RECIPES.forEach(element -> {
            if (element.input instanceof Item)
            {
                GameRegistry.addSmelting((Item)element.input, element.output, element.xp);
            }
            else if (element.input instanceof Block)
            {
                GameRegistry.addSmelting((Block)element.input, element.output, element.xp);
            }
            else
            {
                DesertExpansionMod.logger.error("Incorrect type for @element.input, it may only be a {Item} or a {Block}");
            }

        });
    }
}
