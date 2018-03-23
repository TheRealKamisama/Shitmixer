package com.github.therealkamisama.shitmixer.block;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockLoader
{
    public static Block blockShit = new BlockShit();

    public BlockLoader(FMLPreInitializationEvent event)
    {
        register(blockShit, "BlockShit");
    }

    private static void register(Block block, String name)
    {
        GameRegistry.registerBlock(block.setRegistryName(name));
    }
}