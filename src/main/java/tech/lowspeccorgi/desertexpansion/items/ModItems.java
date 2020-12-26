package tech.lowspeccorgi.desertexpansion.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;

@Mod.EventBusSubscriber(modid = DesertExpansionMod.MODID)
public class ModItems
{
    static Item hardenedSandIngot;

    public static void init()
    {
        hardenedSandIngot = new ItemBase("hardenedSandIngot");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(hardenedSandIngot);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        registerRender(hardenedSandIngot);
    }

    private static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), ""));
    }
}
