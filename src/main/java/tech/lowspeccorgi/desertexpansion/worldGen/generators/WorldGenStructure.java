package tech.lowspeccorgi.desertexpansion.worldGen.generators;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;
import tech.lowspeccorgi.desertexpansion.worldGen.IStructure;

import java.util.Random;

public class WorldGenStructure extends WorldGenerator implements IStructure
{

    public static String structureName;

    public WorldGenStructure(String name)
    {
        this.structureName = name;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        this.generateStructure(worldIn, position);
        return true;
    }

    public static void generateStructure(World world, BlockPos pos)
    {
        MinecraftServer mcServer = world.getMinecraftServer();
        TemplateManager manager = overworldServer.getStructureTemplateManager();
        ResourceLocation location = new ResourceLocation(DesertExpansionMod.MODID, structureName);
        Template template = manager.get(mcServer, location);

        if (template != null)
        {
            IBlockState blockState = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, blockState, blockState, 3);
            template.addBlocksToWorldChunk(world, pos, placementSettings);
        }
    }
}
