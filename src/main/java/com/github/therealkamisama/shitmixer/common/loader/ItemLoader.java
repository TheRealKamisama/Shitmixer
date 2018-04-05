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
import com.github.therealkamisama.shitmixer.common.SMItems;
import com.github.therealkamisama.shitmixer.common.annotation.RegItem;
import com.github.therealkamisama.shitmixer.common.register.RegisterManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemLoader {
    private List<Field> fields = new ArrayList<>();

    public void register() {
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                RegItem annoItem = field.getAnnotation(RegItem.class);
                if (annoItem == null) {
                    if (IForgeRegistryEntry.class.isAssignableFrom(field.getDeclaringClass())) {
                        RegisterManager.getInstance().putRegister((IForgeRegistryEntry) field.get(null));
                    }
                    continue;
                }

                Item item = (Item) field.get(null);
                RegisterManager.getInstance().putRegister(item.setRegistryName(Shitmixer.MODID, annoItem.value()).setUnlocalizedName(annoItem.value()));
            } catch (Throwable ignored) {
            }
        }
    }

    public void registerOre() {
        for (Field field : SMItems.class.getFields()) {
            field.setAccessible(true);
            try {
                RegItem annoItem = field.getAnnotation(RegItem.class);
                if (annoItem == null)
                    continue;

                Item item = (Item) field.get(null);
                Arrays.asList(annoItem.oreDict()).forEach(s -> OreDictionary.registerOre(s, item));
            } catch (Throwable ignored) {
            }
        }
    }

    public void registerRenders() {
        for (Field field : SMItems.class.getFields()) {
            field.setAccessible(true);
            RegItem anno = field.getAnnotation(RegItem.class);
            try {
                if (anno == null)
                    continue;

                Item item = (Item) field.get(null);

                registerRender(item, 0);

            } catch (Exception ignored) {
            }
        }
    }

    private void registerRender(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public List<Field> getFields() {
        return fields;
    }
}
