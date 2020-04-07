package me.mayermad.jdabot.command.commands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.Activity;

import java.security.KeyStore;
import java.util.List;

public class GameCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        if (args.isEmpty()){
            ctx.getJDA().getPresence().setActivity(Activity.listening("Jazz"));
            return;
        }
        String game = String.join(" ",args);
        ctx.getJDA().getPresence().setActivity(Activity.playing(game));
    }

    @Override
    public String getName() {
        return "game";
    }

    @Override
    public String getHelp() {
        return "kann man machen";
    }
}
