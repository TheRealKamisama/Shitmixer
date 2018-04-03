package com.github.therealkamisama.shitmixer.common;

import com.github.therealkamisama.shitmixer.ShitDroppingHandler;
import com.github.therealkamisama.shitmixer.common.loader.BlockLoader;
import com.github.therealkamisama.shitmixer.common.loader.ItemLoader;
import com.github.therealkamisama.shitmixer.common.register.RegisterLoader;
import com.github.therealkamisama.shitmixer.crafting.CraftingLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public RegisterLoader registerLoader = new RegisterLoader();

    public CommonProxy() {
        new ItemLoader();
        new BlockLoader();
        new ShitDroppingHandler();
    }

    public void preInit(FMLPreInitializationEvent event)
    {
        new ConfigLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
        new CraftingLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
        registerLoader.registerOre();
    }
}
