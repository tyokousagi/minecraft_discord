package me.tyokousagi.minecraft_discord;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class BOT extends ListenerAdapter {
    static Dotenv dotenv = Dotenv.load();

    private static JDA jda = null;
    public static void init() throws InterruptedException {
        String token = dotenv.get("token");
        jda = JDABuilder.createDefault(token)
                .setRawEventsEnabled(true)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new BOT())
                .setActivity(Activity.playing("連携しちゃうにょ～～"))
                .setAutoReconnect(true)
                .build();
        jda.awaitReady();
    }
    public static JDA getJDA() {
        return jda;
    }
}
