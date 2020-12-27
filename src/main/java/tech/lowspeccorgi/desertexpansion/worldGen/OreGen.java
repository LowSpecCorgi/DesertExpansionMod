package tech.lowspeccorgi.desertexpansion.worldGen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import tech.lowspeccorgi.desertexpansion.blocks.ModBlocks;

import java.util.Random;
import com.google.common.base.Predicate;

public class OreGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.getDimension())
        {
            // Nether
            case -1:
                if (world.provider.getBiomeProvider().getBiome(new BlockPos(chunkX, 0, chunkZ)).equals(Biome.getBiome(2)))
                {
                    runGenerator(ModBlocks.hardenedSand.getDefaultState(), 7, 80, 12, 50, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                }
            // Overworld
            case 0:
                break;
            // End
            case 1:
                break;
            // Everything else
            default:
                break;
        }
    }

    private void runGenerator(
            IBlockState blockToGen,
            int blockAmount,
            int chancesToSpawn,
            int minHeight,
            int maxHeight,
            Predicate<IBlockState> blockToReplace,
            World world,
            Random rand,
            int chunk_x,
            int chunk_z)
    {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        WorldGenMinable generator = new WorldGenMinable(blockToGen, blockAmount, blockToReplace);
        int heightdiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i++)
        {
            int x = chunk_x * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightdiff);
            int z = chunk_z * 16 + rand.nextInt(16);

            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
