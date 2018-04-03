package com.github.therealkamisama.shitmixer.block;

import com.github.therealkamisama.shitmixer.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockShit extends Block
{
    public BlockShit()
    {
        super(Material.GROUND);
        this.setHardness(0F);
        this.setCreativeTab(CreativeTabsLoader.tabShitmixer);
    }

}