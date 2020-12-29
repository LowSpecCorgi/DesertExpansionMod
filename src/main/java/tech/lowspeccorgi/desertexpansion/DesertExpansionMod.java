package tech.lowspeccorgi.desertexpansion;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import tech.lowspeccorgi.desertexpansion.blocks.ModBlocks;
import tech.lowspeccorgi.desertexpansion.items.ModItems;
import tech.lowspeccorgi.desertexpansion.recipies.ModRecipes;
import tech.lowspeccorgi.desertexpansion.worldGen.ModGens;

@Mod(modid = DesertExpansionMod.MODID, name = DesertExpansionMod.NAME, version = DesertExpansionMod.VERSION)
public class DesertExpansionMod
{
    public static final String MODID = "desertexpansionmod";
    public static final String NAME = "Desert Expansion Mod";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info(MODID + " :preInit");
        ModItems.init();
        ModBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info(MODID + " :init");
        ModRecipes.init();
        ModGens.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        logger.info(MODID + " :postInit");
    }
}
