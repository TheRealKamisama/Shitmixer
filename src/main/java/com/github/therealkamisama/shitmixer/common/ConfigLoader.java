package com.github.therealkamisama.shitmixer.common;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


public class ConfigLoader {
    private static Configuration config;

    private static Logger logger;

    private static int shitGenerateTime;
    private static boolean generateShit;
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

        comment = "你想让全世界的生物多少秒随机喷一次屎，" +
                "写鸭蛋进去的话你思考一下除法运算里除数不能是几？ ";
        shitGenerateTime = config.get(Configuration.CATEGORY_GENERAL, "shitGenerateTime", 600, comment).getInt();

        comment = "写true就会喷屎，写false全世界动物便秘一辈子";
        generateShit = config.get(Configuration.CATEGORY_GENERAL, "generateShit", true, comment).getBoolean();

        config.save();
        logger.info("Finished loading config. ");
    }

    public static Logger logger()
    {
        return logger;
    }

    public static int getShitGenerateTime() {
        return shitGenerateTime * 20;
    }
    public static boolean getshitGenerateBoolean(){
        return generateShit;
    }
}