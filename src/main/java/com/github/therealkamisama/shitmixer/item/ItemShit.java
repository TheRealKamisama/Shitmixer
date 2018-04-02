package com.github.therealkamisama.shitmixer.item;

import com.github.therealkamisama.shitmixer.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemShit extends Item
{
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    public ItemShit()
    {
        super();
        this.setUnlocalizedName("shit");
        this.setRegistryName("shit");
        this.setCreativeTab(CreativeTabsLoader.tabShitmixer);
    }
}