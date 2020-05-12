package me.mayermad.jdabot.command.commands.dice;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.ThreadLocalRandom;

public class CoinCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        TextChannel channel = ctx.getChannel();

        boolean toss = ThreadLocalRandom.current().nextBoolean();
        if(toss){
            channel.sendMessage(ctx.getEvent().getAuthor().getAsMention() + " Gut für die Spieler").queue();
            return;}
        channel.sendMessage(ctx.getEvent().getAuthor().getAsMention() + " Schlecht für die Spieler").queue();
    }

    @Override
    public String getHelp() {
        return "Flips a coin" +
                "Usage: `coin`";
    }

    @Override
    public String getName() {
        return "risk";
    }
}
