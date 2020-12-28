package tech.lowspeccorgi.desertexpansion.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = DesertExpansionMod.MODID)
public class ModItems
{
    public static ArrayList<Item> ITEMS = new ArrayList<Item>();

    /* Declare items here, items auto register as well */
    public static final Item hardenedSandIngot = new ItemBase("hardenedSandIngot");;
    public static final DehydratedFlesh dehydratedFlesh = new DehydratedFlesh("dehydratedFlesh", 5, 0.3f, false);

    public static void init()
    {
        // Todo.
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        ITEMS.forEach(element -> event.getRegistry().register(element));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        ITEMS.forEach(element -> registerRender(element));
    }

    private static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}

