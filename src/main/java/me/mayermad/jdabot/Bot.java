package me.mayermad.jdabot;

import me.mayermad.jdabot.storage.LiteSQL;
import me.mayermad.jdabot.storage.SQLManager;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    private Bot() throws LoginException {

        LiteSQL.setConnection();
        SQLManager.onCreate();

        new JDABuilder()
                .setToken(Config.get("token"))
                .addEventListeners(new Listener())//.setActivity(Activity.playing("Only War"))
                .setActivity(Activity.listening("Jazz"))
                .build();

    }

    public static void main(String[] args) throws LoginException {
        new Bot();
    }

}
