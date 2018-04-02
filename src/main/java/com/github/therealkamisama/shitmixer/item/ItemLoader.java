package com.github.therealkamisama.shitmixer.item;

import com.github.therealkamisama.shitmixer.common.register.RegisterManager;
import net.minecraft.item.Item;

public class ItemLoader
{
    public ItemLoader() {
        RegisterManager.getInstance().putRegister(shit);
        RegisterManager.getInstance().putRegister(shitcookie);
    }

    public static Item shitcookie = new ItemShitCookie();
    public static Item shit = new ItemShit();


}
