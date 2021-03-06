package com.github.therealkamisama.shitmixer;

import com.github.therealkamisama.shitmixer.common.ConfigLoader;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static com.github.therealkamisama.shitmixer.common.SMItems.shit;


public class ShitDroppingHandler {

    public ShitDroppingHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void shitDropping(LivingDeathEvent event) {
        event.getEntityLiving().entityDropItem(new ItemStack(shit), 1);
    }

    @SubscribeEvent
    public void shitDropTiming(TickEvent.WorldTickEvent event) {
        final long ticks = event.world.getWorldTime();
        if (ConfigLoader.getshitGenerateBoolean()){
            if (ticks % ConfigLoader.getShitGenerateTime() == 0) {
                event.world.getEntities(EntityAnimal.class, entity -> true).forEach(entity ->
                        entity.entityDropItem(new ItemStack(shit), 1));
            }
        }
    }
}