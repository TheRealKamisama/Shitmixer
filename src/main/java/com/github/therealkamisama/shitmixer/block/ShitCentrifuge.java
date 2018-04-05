package com.github.therealkamisama.shitmixer.block;


import com.github.therealkamisama.shitmixer.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ShitCentrifuge extends Block {
    public ShitCentrifuge() {
        super(Material.IRON);
        this.setHardness(5F);
        this.setCreativeTab(CreativeTabsLoader.tabShitmixer);
    }
}
