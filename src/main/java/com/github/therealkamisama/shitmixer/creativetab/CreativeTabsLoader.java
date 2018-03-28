package com.github.therealkamisama.shitmixer.creativetab;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader
{
    public static CreativeTabs tabShitmixer;

    public CreativeTabsLoader()
    {
        tabShitmixer = new CreativeTabsShitmixer();
    }
}