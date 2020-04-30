package me.mayermad.jdabot.command.commands.gameCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class GameCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        if (args.isEmpty()){
            ctx.getJDA().getPresence().setActivity(Activity.listening("Jazz"));
            return;
        }
        String game = String.join(" ",args);
        ctx.getJDA().getPresence().setActivity(Activity.playing(game));
        channel.addReactionById(ctx.getMessage().getId(), "\uD83D\uDC4D").queue();
    }

    @Override
    public String getName() {
        return "game";
    }

    @Override
    public String getHelp() {
        return "Usage: `game @g` with `g = Game Name`\n valid games are:\n `Warhammer Fantasy RPG`\n `Only War` \n `Dark Heresy`";
    }
}
