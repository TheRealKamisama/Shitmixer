package com.github.therealkamisama.shitmixer.item;

import com.github.therealkamisama.shitmixer.common.register.RegisterManager;
import net.minecraft.item.Item;

public class ItemLoader
{
    public static Item shitcookie = new ItemShitCookie();
    public static Item shit = new ItemShit();

    public ItemLoader()
    {
        register(shit, "shit");
        register(shitcookie, "shit_cookie");
    }

    private static void register(Item item, String name)
    {
        RegisterManager.getInstance().putRegister(item.setRegistryName(name));
    }
}
