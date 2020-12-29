package tech.lowspeccorgi.desertexpansion.items;

import net.minecraft.item.Item;
import tech.lowspeccorgi.desertexpansion.creativeTabs.ModTabs;

public class ItemBase extends Item
{
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ModTabs.desertExpansionTab);
        ModItems.ITEMS.add(this);
    }
}
