package com.github.therealkamisama.shitmixer.common;

import com.github.therealkamisama.shitmixer.block.BlockShit;
import com.github.therealkamisama.shitmixer.block.ShitCentrifuge;
import com.github.therealkamisama.shitmixer.common.annotation.RegBlock;
import net.minecraft.block.Block;

public interface SMBlocks {
    @RegBlock("block_shit")
    Block blockShit = new BlockShit();
    @RegBlock("shit_centrifuge")
    Block shitCentrifuge = new ShitCentrifuge();
}
