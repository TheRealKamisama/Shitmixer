package com.github.therealkamisama.shitmixer.common;

import com.github.therealkamisama.shitmixer.Item.ItemLoader;
import com.github.therealkamisama.shitmixer.block.BlockLoader;
import com.github.therealkamisama.shitmixer.crafting.CraftingLoader;
import com.github.therealkamisama.shitmixer.creativetab.CreativeTabsLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        new CreativeTabsLoader(event);
        new ItemLoader(event);
        new BlockLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
        new CraftingLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
