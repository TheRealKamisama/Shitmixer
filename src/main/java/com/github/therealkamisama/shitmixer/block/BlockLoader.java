package com.github.therealkamisama.shitmixer.block;


import com.github.therealkamisama.shitmixer.common.register.RegisterManager;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BlockLoader
{
    public static Block blockShit = new BlockShit();

    public BlockLoader()
    {
        register(blockShit, "block_shit");
    }

    private static void register(Block block, String name)
    {
        RegisterManager.getInstance().putRegister(block.setRegistryName(name));
        RegisterManager.getInstance().putRegister(new ItemBlock(block).setRegistryName(name));
    }
}