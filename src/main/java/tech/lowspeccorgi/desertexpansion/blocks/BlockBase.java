package tech.lowspeccorgi.desertexpansion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;

public class BlockBase extends Block
{
    public BlockBase(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DesertExpansionMod.desertExpansionTab);
        ModBlocks.BLOCKS.add(this);
    }
}
