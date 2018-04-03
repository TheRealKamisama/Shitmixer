package com.github.therealkamisama.shitmixer.item;

import net.minecraft.item.ItemFood;
import com.github.therealkamisama.shitmixer.creativetab.CreativeTabsLoader;

public class ItemShitCookie extends ItemFood
{
    public ItemShitCookie()
    {
        super(4, 0.1F, false);
        this.setAlwaysEdible();
        this.setCreativeTab(CreativeTabsLoader.tabShitmixer);
    }
}