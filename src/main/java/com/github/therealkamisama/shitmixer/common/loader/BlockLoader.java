/*
 * FoodCraft Mod - Add more food to your Minecraft.
 * Copyright (C) 2017 Lasm Gratel
 *
 * This file is part of FoodCraft Mod.
 *
 * FoodCraft Mod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FoodCraft Mod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with FoodCraft Mod.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.therealkamisama.shitmixer.common.loader;

import com.github.therealkamisama.shitmixer.Shitmixer;
import com.github.therealkamisama.shitmixer.common.annotation.RegBlock;
import com.github.therealkamisama.shitmixer.common.register.RegisterManager;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockLoader {
    private List<Field> fields = new ArrayList<>();

    public void register() {
        for (Field field : fields) {
            try {
                field.setAccessible(true);

                Block block = (Block) field.get(null);
                RegBlock anno = field.getAnnotation(RegBlock.class);

                RegisterManager.getInstance().putRegister(block.setRegistryName(Shitmixer.MODID, anno.value()).setUnlocalizedName(anno.value()));

                // Register item block.
                Class<? extends ItemBlock> itemClass = anno.itemClass();
                Constructor<? extends ItemBlock> con = itemClass.getConstructor(Block.class);
                con.setAccessible(true);
                RegisterManager.getInstance().putRegister(con.newInstance(block).setRegistryName(Shitmixer.MODID, anno.value()).setUnlocalizedName(anno.value()));

                Arrays.asList(anno.oreDict()).forEach(s -> OreDictionary.registerOre(s, block));
            } catch (Throwable e) {
            }
        }
    }

    public List<Field> getFields() {
        return fields;
    }
}
