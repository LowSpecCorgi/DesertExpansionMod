package tech.lowspeccorgi.desertexpansion.worldGen;

import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

public class ModGens {
    public static ArrayList<IWorldGenerator> WORLD_GENS = new ArrayList<>();

    /* Declare world gens here */
    public static final OreGen oreGen = new OreGen();
    public static final StructureGen structureGen = new StructureGen();

    public static void init()
    {
        WORLD_GENS.forEach(element -> {
            GameRegistry.registerWorldGenerator(element, 0);
        });
    }
}
