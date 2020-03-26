package me.mayermad.jdabot.command.commands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.ThreadLocalRandom;

public class CoinCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        TextChannel channel = ctx.getChannel();
        Boolean toss = ThreadLocalRandom.current().nextBoolean();
        if(toss){
            channel.sendMessage("Kopf").queue();
            return;}
        channel.sendMessage("Zahl").queue();
    }

    @Override
    public String getHelp() {
        return "Flips a coin" +
                "Usage: `coin`";
    }

    @Override
    public String getName() {
        return "coin";
    }
}
