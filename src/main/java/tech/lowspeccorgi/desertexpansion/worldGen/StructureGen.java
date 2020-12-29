package tech.lowspeccorgi.desertexpansion.worldGen;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;
import tech.lowspeccorgi.desertexpansion.worldGen.generators.WorldGenStructure;

import java.util.ArrayList;
import java.util.Random;

public class StructureGen implements IWorldGenerator
{
    public static final WorldGenStructure SAND_WELL = new WorldGenStructure("sandwell");

    public StructureGen()
    {
        ModGens.WORLD_GENS.add(this);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.getDimension())
        {
            // Nether
            case -1:
                break;
            // Overworld
            case 0:
                generateStructure(SAND_WELL, world, random, chunkX, chunkZ, 255, Blocks.SAND, BiomeDesert.class);
            // End
            case 1:
                break;
            // Everything else
            default:
                break;
        }
    }

    private void generateStructure(
            WorldGenerator generator,
            World world,
            Random random,
            int chunkX,
            int chunkZ,
            int chance,
            Block topBlock,
            Class<?>... classes)
    {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if (world.getWorldType() != WorldType.FLAT)
        {
            if (classesList.contains(biome))
            {
                if (random.nextInt(chance) == 0)
                {
                    generator.generate(world, random, pos);
                }
            }
        }
    }

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
    {
        int y = world.getHeight();
        boolean foundGround = false;

        while (!foundGround & y-- >= 0)
        {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = (block == topBlock);
        }

        return y;
    }
}
