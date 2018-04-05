package com.github.therealkamisama.shitmixer.common;

import com.github.therealkamisama.shitmixer.ShitDroppingHandler;
import com.github.therealkamisama.shitmixer.common.annotation.RegBlock;
import com.github.therealkamisama.shitmixer.common.annotation.RegItem;
import com.github.therealkamisama.shitmixer.common.loader.BlockLoader;
import com.github.therealkamisama.shitmixer.common.loader.ItemLoader;
import com.github.therealkamisama.shitmixer.common.register.RegisterLoader;
import com.github.therealkamisama.shitmixer.crafting.CraftingLoader;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.objectweb.asm.Type;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class CommonProxy
{
    public RegisterLoader registerLoader = new RegisterLoader();
    public ItemLoader itemLoader = new ItemLoader();
    public BlockLoader blockLoader = new BlockLoader();

    public CommonProxy() {
        new ShitDroppingHandler();
    }

    public void preInit(FMLPreInitializationEvent event)
    {
        new ConfigLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
        new CraftingLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
        registerLoader.registerOre();
    }

    public void construct(FMLConstructionEvent event) {
        for (ASMDataTable.ASMData entry : event.getASMHarvestedData().getAll(RegBlock.class.getName())) {
            final String targetClass = entry.getClassName();
            final String targetName = entry.getObjectName();

            Type type = Type.getObjectType(entry.getAnnotationInfo().get("value").toString());

            final String capabilityName = type.getInternalName().replace('/', '.').intern();

            if (entry.getObjectName().indexOf('(') <= 0) {
                try {
                    Field field = Class.forName(targetClass).getDeclaredField(targetName);
                    if ((field.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                        FMLLog.log.warn("Unable to inject block {} at {}.{} (Non-Static)", capabilityName, targetClass, targetName);
                    }
                    blockLoader.getFields().add(field);
                } catch (Exception e) {
                    FMLLog.log.warn("Unable to inject block {} at {}.{}", capabilityName, targetClass, targetName, e);
                }
            }
        }
        blockLoader.register();

        for (ASMDataTable.ASMData entry : event.getASMHarvestedData().getAll(RegItem.class.getName())) {
            final String targetClass = entry.getClassName();
            final String targetName = entry.getObjectName();

            Type type = Type.getObjectType(entry.getAnnotationInfo().get("value").toString());

            final String capabilityName = type.getInternalName().replace('/', '.').intern();

            if (entry.getObjectName().indexOf('(') <= 0) {
                try {
                    Field field = Class.forName(targetClass).getDeclaredField(targetName);
                    if ((field.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                        FMLLog.log.warn("Unable to inject item {} at {}.{} (Non-Static)", capabilityName, targetClass, targetName);
                    }
                    itemLoader.getFields().add(field);
                } catch (Exception e) {
                    FMLLog.log.warn("Unable to inject item {} at {}.{}", capabilityName, targetClass, targetName, e);
                }
            }
        }

        itemLoader.register();
    }
}
