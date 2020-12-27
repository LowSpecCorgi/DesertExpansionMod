package tech.lowspeccorgi.desertexpansion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tech.lowspeccorgi.desertexpansion.DesertExpansionMod;
import tech.lowspeccorgi.desertexpansion.items.ModItems;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = DesertExpansionMod.MODID)
public class ModBlocks
{
    public static ArrayList<Block> BLOCKS = new ArrayList<Block>();

    /* Declare blocks here, items auto register as well */
    public static final Block hardenedSand = new BlockOre("hardenedSand", Material.ROCK, ModItems.hardenedSandIngot, 1, 5).setHardness(3.0f);

    public static void init()
    {
        // Todo.
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        BLOCKS.forEach(element -> event.getRegistry().register(element));
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        BLOCKS.forEach(element -> event.getRegistry().register(
                new ItemBlock(element)
                    .setRegistryName(element.getRegistryName())
        ));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        BLOCKS.forEach(element -> registerRender(Item.getItemFromBlock(element)));
    }

    public static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }
}
