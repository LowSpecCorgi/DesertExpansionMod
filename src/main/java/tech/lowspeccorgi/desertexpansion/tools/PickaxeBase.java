package tech.lowspeccorgi.desertexpansion.tools;

import net.minecraft.item.ItemPickaxe;
import tech.lowspeccorgi.desertexpansion.creativeTabs.ModTabs;
import tech.lowspeccorgi.desertexpansion.items.ModItems;

public class PickaxeBase extends ItemPickaxe
{
    public PickaxeBase(String name, ToolMaterial material)
    {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        setCreativeTab(ModTabs.desertExpansionTab);
        ModItems.ITEMS.add(this);
    }
}
