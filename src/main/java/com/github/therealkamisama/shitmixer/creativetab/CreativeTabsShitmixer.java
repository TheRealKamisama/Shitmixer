package com.github.therealkamisama.shitmixer.creativetab;


import com.github.therealkamisama.shitmixer.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsShitmixer extends CreativeTabs
{
    public CreativeTabsShitmixer()
    {
        super("Shitmixer");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemLoader.shit);
    }
}