package com.github.therealkamisama.shitmixer.common;

import com.github.therealkamisama.shitmixer.common.annotation.RegItem;
import com.github.therealkamisama.shitmixer.item.ItemShit;
import com.github.therealkamisama.shitmixer.item.ItemShitCookie;
import net.minecraft.item.Item;

public interface SMItems {
    @RegItem("shit_cookie")
    Item shitcookie = new ItemShitCookie();

    @RegItem("shit")
    Item shit = new ItemShit();
}
