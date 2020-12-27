package tech.lowspeccorgi.desertexpansion.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOre extends BlockBase
{
    Item toDrop;
    int minDropAmount = 1;
    int maxDropAmount = 0;

    /**
     * Constructs a new {@link BlockOre} class
     * @param name
     *  The name of the ore
     * @param material
     *  The material of the ore
     * @param toDrop
     *  The item that shall be dropped
     * @param minDropAmount
     *  The minimum amount of items that can be dropped
     * @param maxDropAmount
     *  The maximum amount of items that can be dropped
     */
    public BlockOre(String name, Material material, Item toDrop, int minDropAmount, int maxDropAmount)
    {
        super(name, material);
        this.toDrop = toDrop;
        this.minDropAmount = minDropAmount;
        this.maxDropAmount = maxDropAmount;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return toDrop==null?Item.getItemFromBlock(this):toDrop;
    }

    @Override
    public int quantityDropped(Random random)
    {
        if (this.minDropAmount > this.maxDropAmount)
        {
            int temp = this.maxDropAmount;
            this.maxDropAmount = this.minDropAmount;
            this.minDropAmount = temp;
        }

        return this.minDropAmount + random.nextInt(this.maxDropAmount - this.minDropAmount);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0)
            {
                i = 0;
            }
            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
}
