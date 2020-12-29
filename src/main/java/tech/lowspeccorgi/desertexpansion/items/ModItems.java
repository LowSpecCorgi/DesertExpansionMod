package tech.lowspeccorgi.desertexpansion.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;
import tech.lowspeccorgi.desertexpansion.tools.PickaxeBase;

import java.util.ArrayList;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = DesertExpansionMod.MODID)
public class ModItems
{
    public static ArrayList<Item> ITEMS = new ArrayList<>();

    /* Declare items here, items auto register as well */
    public static final Item hardenedSandIngot = new ItemBase("hardenedSandIngot");
    public static final DehydratedFlesh dehydratedFlesh = new DehydratedFlesh("dehydratedFlesh", 5, 0.3f, false);

    /* Declare tools materials here */
    public static final Item.ToolMaterial hardenedSandToolMaterial = EnumHelper.addToolMaterial(
            "hardenedSandToolMaterial",
            2,
            131,
            6.0f,
            0.0f,
            15);

    /* Declare tools here */
    public static final PickaxeBase hardenedSandPickaxe = new PickaxeBase("hardenedSandPickaxe", hardenedSandToolMaterial);

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
        ITEMS.forEach(ModItems::registerRender);
    }

    private static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}

