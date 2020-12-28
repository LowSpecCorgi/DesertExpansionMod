package tech.lowspeccorgi.desertexpansion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;
import tech.lowspeccorgi.desertexpansion.creativeTabs.ModTabs;

public class BlockBase extends Block
{
    public BlockBase(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ModTabs.desertExpansionTab);
        ModBlocks.BLOCKS.add(this);
    }
}
