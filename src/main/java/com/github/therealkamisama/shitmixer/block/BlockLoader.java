package com.github.therealkamisama.shitmixer.block;


import com.github.therealkamisama.shitmixer.common.register.RegisterManager;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BlockLoader {
    public static Block blockShit = new BlockShit();

    public BlockLoader() {
        RegisterManager.getInstance().putRegister(blockShit);
        RegisterManager.getInstance().putRegister(new ItemBlock(blockShit).setRegistryName("block_shit"));
    }
}