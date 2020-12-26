package tech.lowspeccorgi.desertexpansion.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DesertExpansionTab extends CreativeTabs
{

    public DesertExpansionTab(String label)
    {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(Item.getByNameOrId("minecraft:sand"));
    }
}
