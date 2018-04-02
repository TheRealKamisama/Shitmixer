package com.github.therealkamisama.shitmixer;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static com.github.therealkamisama.shitmixer.item.ItemLoader.shit;

public class shitDropping {
    int shitTiming = 0;


    public shitDropping() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void shitDropping(LivingDeathEvent event) {
        event.getEntityLiving().entityDropItem(new ItemStack(shit), 1);
    }

    @SubscribeEvent
    public void shitDropTiming(TickEvent.WorldTickEvent event) {
        shitTiming = shitTiming+1;
        if (shitTiming == 6000){
            event.world.getEntities(EntityAnimal.class, entity -> true).forEach(entity -> {
                entity.entityDropItem(new ItemStack(shit), 1);
            });
            shitTiming = 0;
        }
    }
}