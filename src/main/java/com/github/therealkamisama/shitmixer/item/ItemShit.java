package com.github.therealkamisama.shitmixer.item;

import com.github.therealkamisama.shitmixer.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;

public class ItemShit extends Item
{
    public ItemShit()
    {
        super();
        this.setUnlocalizedName("shit");
        this.setCreativeTab(CreativeTabsLoader.tabShitmixer);
    }
}