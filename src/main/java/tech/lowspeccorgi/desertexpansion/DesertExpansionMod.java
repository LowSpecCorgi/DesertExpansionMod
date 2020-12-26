package tech.lowspeccorgi.desertexpansion;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import tech.lowspeccorgi.desertexpansion.creativeTabs.DesertExpansionTab;
import tech.lowspeccorgi.desertexpansion.items.ModItems;

@Mod(modid = DesertExpansionMod.MODID, name = DesertExpansionMod.NAME, version = DesertExpansionMod.VERSION)
public class DesertExpansionMod
{
    public static final String MODID = "desertexpansionmod";
    public static final String NAME = "Desert Expansion Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    /* CREATIVE TABS */
    public static final CreativeTabs desertExpansionTab = new DesertExpansionTab("tabDesertExpansion");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info(MODID + " :preInit");
        ModItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info(MODID + " :init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        logger.info(MODID + " :postInit");
    }
}
