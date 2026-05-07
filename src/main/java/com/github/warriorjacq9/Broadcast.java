package com.github.warriorjacq9;

import com.github.warriorjacq9.util.BroadcastBlocks;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Broadcast implements ModInitializer {
	public static final String MOD_ID = "broadcast";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        BroadcastBlocks.init();
	}
}