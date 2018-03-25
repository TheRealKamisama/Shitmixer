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
    public static Item shitcookie = new ItemShitCookie();
    public static Item shit = new ItemShit();

    public ItemLoader(FMLPreInitializationEvent event)
    {
        register(shit, "shit");
        register(shitcookie, "shitCookie");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(shit);
        registerRender(shitcookie);
    }

    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item.setRegistryName(name));

    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}
