package com.github.therealkamisama.shitmixer.crafting;

import com.github.therealkamisama.shitmixer.Item.ItemLoader;
import com.github.therealkamisama.shitmixer.block.BlockLoader;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader
{
    public CraftingLoader()
    {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe()
    {       GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blockShit),
                    "SSS", "SSS", "SSS", 'S', ItemLoader.shit);

    }

    private static void registerSmelting()
    {

    }

    private static void registerFuel()
    {

    }
}