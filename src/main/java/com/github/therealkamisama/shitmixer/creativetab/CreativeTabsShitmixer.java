package com.github.therealkamisama.shitmixer.creativetab;


import com.github.therealkamisama.shitmixer.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class CreativeTabsShitmixer extends CreativeTabs
{
    public CreativeTabsShitmixer()
    {
        super("Shitmixer");
    }

    @Override
    @Nonnull
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemLoader.shit);
    }
}
