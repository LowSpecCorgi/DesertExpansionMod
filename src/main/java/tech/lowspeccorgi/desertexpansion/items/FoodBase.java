package tech.lowspeccorgi.desertexpansion.items;

import net.minecraft.item.ItemFood;
import tech.lowspeccorgi.desertexpansion.creativeTabs.ModTabs;

public class FoodBase extends ItemFood {
    public FoodBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ModTabs.desertExpansionTab);
        ModItems.ITEMS.add(this);
    }
}
