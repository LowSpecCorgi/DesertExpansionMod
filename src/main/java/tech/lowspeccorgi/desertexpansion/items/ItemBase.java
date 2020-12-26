package tech.lowspeccorgi.desertexpansion.items;

import net.minecraft.item.Item;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;


public class ItemBase extends Item
{
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DesertExpansionMod.desertExpansionTab);
    }
}
