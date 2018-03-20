package com.github.therealkamisama.shitmixer;

import com.github.therealkamisama.shitmixer.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author ustc_zzzz
 */
@Mod(modid = shitmixer.MODID, name = shitmixer.NAME, version = shitmixer.VERSION, acceptedMinecraftVersions = "1.8.9")
public class shitmixer
{
    public static final String MODID = "shitmixer";
    public static final String NAME = "ShitMixer";
    public static final String VERSION = "1.0.0";

    @Instance(shitmixer.MODID)
    public static shitmixer instance;

    @SidedProxy(clientSide = "com.github.therealkamisama.shitmixer.client.ClientProxy", serverSide = "com.github.therealkamisama.shitmixer.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
