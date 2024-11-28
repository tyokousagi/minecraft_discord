package me.tyokousagi.minecraft_discord.event;

import io.github.cdimascio.dotenv.Dotenv;
import me.tyokousagi.minecraft_discord.BOT;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.minecraft.server.network.ServerPlayerEntity;

import java.awt.*;
import java.util.Objects;


public class Events {
    static Dotenv dotenv = Dotenv.load();
    private static final String channelId = dotenv.get("channel_id");
    private static final String guildId = dotenv.get("guild_id");
    private static final String headUrl = "https://mc-heads.net/avatar/";
    private static final JDA jda = BOT.getJDA();

    public static void ConnectEvent(ServerPlayerEntity player) {
        String playerName = player.getEntityName();
        TextChannel channel = Objects.requireNonNull(jda.getGuildById(guildId)).getTextChannelById(channelId);

        if(channel != null) {
            channel.sendMessageEmbeds(
                    new EmbedBuilder()
                            .setAuthor(playerName + "が参加しました",null,headUrl + playerName + ".png")
                            .setColor(Color.GREEN)
                            .build()
            ).queue();
        }else {
            System.out.println("channelがnullな可能性があります");
        }
        System.out.println(headUrl + playerName + ".png");

        System.out.println("接続しました");
    }
    public static void DisConnectEvent(ServerPlayerEntity player) {
        String playerName = player.getEntityName();
        TextChannel channel = Objects.requireNonNull(jda.getGuildById(guildId)).getTextChannelById(channelId);


        if(channel != null) {
            channel.sendMessageEmbeds(
                    new EmbedBuilder()
                            .setAuthor(playerName + "が退出しました",null,headUrl + playerName + ".png")
                            .setColor(Color.GRAY)
                            .build()
            ).queue();
        }else {
            System.out.println("channelがnullな可能性があります");
        }

        System.out.println(headUrl + playerName + ".png");

        System.out.println("切断しました");

    }
}
