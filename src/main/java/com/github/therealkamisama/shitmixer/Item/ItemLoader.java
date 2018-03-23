package com.github.therealkamisama.shitmixer.Item;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader
{
    public static Item shit = new ItemShit();

    public ItemLoader(FMLPreInitializationEvent event)
    {
        register(shit, "shit");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(shit);
    }

    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item.setRegistryName("shitmixer",name));
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelBakery.registerItemVariants(item, model);
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
        ModelLoader.setCustomMeshDefinition(item, stack -> model);
    }
}
