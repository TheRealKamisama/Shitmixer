package com.github.therealkamisama.shitmixer.common;

import com.github.therealkamisama.shitmixer.block.BlockLoader;
import com.github.therealkamisama.shitmixer.common.register.RegisterLoader;
import com.github.therealkamisama.shitmixer.crafting.CraftingLoader;
import com.github.therealkamisama.shitmixer.creativetab.CreativeTabsLoader;
import com.github.therealkamisama.shitmixer.item.ItemLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public RegisterLoader registerLoader = new RegisterLoader();

    public CommonProxy() {
        new CreativeTabsLoader();
        new ItemLoader();
        new BlockLoader();
    }

    public void preInit(FMLPreInitializationEvent event)
    {
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
