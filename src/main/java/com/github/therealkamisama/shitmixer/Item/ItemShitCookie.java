package com.github.therealkamisama.shitmixer.Item;

import net.minecraft.item.ItemFood;

import com.github.therealkamisama.shitmixer.creativetab.CreativeTabsLoader;

public class ItemShitCookie extends ItemFood
{
    public ItemShitCookie()
    {
        super(4, 0.1F, false);
        this.setAlwaysEdible();
        this.setUnlocalizedName("shitCookie");
        this.setCreativeTab(CreativeTabsLoader.tabShitmixer);
    }
}