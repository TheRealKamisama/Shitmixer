package com.github.therealkamisama.shitmixer.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader
{
    public static CreativeTabs tabShitmixer;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
        tabShitmixer = new CreativeTabsShitmixer ();
    }
}