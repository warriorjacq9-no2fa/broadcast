package com.github.warriorjacq9.broadcast.util;

import com.github.warriorjacq9.broadcast.Broadcast;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class BroadcastBlocks {
    public static final Block TRANSMITTER = register(
            "broadcaster", Block::new, AbstractBlock.Settings.create().strength(0.4f)
    );

    public static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier id = Identifier.of(Broadcast.MOD_ID, path);
        final RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        final Block block = Blocks.register(key, factory, settings);
        Items.register(block);
        return block;
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(
                (itemGroup) -> itemGroup.add(TRANSMITTER.asItem())
        );
    }
}
