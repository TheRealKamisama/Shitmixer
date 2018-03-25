package com.github.therealkamisama.shitmixer.crafting;

import com.github.therealkamisama.shitmixer.Item.ItemLoader;
import com.github.therealkamisama.shitmixer.block.BlockLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
            GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.shitcookie),
                    "SSS", "SCS", "SSS", 'S',ItemLoader.shit, 'C', Items.cookie);


    }

    private static void registerSmelting()
    {

    }

    private static void registerFuel()
    {

    }
}