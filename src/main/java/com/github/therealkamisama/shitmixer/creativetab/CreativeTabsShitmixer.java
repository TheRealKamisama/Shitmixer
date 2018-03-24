package com.github.therealkamisama.shitmixer.creativetab;


import com.github.therealkamisama.shitmixer.Item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsShitmixer extends CreativeTabs
{
    public CreativeTabsShitmixer()
    {
        super("Shitmixer");
    }

    @Override
    public Item getTabIconItem()
    {
        return ItemLoader.shit;
    }
}