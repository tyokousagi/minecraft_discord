package me.tyokousagi.minecraft_discord;

import me.tyokousagi.minecraft_discord.event.Events;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class Minecraft_discord implements ModInitializer {

    @Override
    public void onInitialize() {
        try {
            BOT.init();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ServerPlayConnectionEvents.JOIN.register(((handler, sender, server) -> {
            ServerPlayerEntity player = handler.player;
            Events.ConnectEvent(player);
        }));
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            ServerPlayerEntity player = handler.player;
            Events.DisConnectEvent(player);
        });
    }
}
