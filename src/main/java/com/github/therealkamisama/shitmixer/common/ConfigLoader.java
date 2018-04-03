package com.github.therealkamisama.shitmixer.common;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


public class ConfigLoader {
    private static Configuration config;

    private static Logger logger;

    public static int shitgeneratetime;

    public ConfigLoader(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();
        load();
    }

    public static void load()
    {
        logger.info("Started loading config. ");
        String comment;

        comment = "你想让全世界的生物多久喷一次屎，" +
                "写鸭蛋进去的话六年喷一次。 ";
        shitgeneratetime = config.get(Configuration.CATEGORY_GENERAL, "shitGenerate", 600, comment).getInt();

        config.save();
        logger.info("Finished loading config. ");
    }

    public static Logger logger()
    {
        return logger;
    }

}