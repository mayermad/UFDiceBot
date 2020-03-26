package me.mayermad.jdabot.command.commands;

import me.mayermad.jdabot.Config;
import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DmgCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        if (args.isEmpty()) {
            StringBuilder builder = new StringBuilder();

            int d10 = ThreadLocalRandom.current().nextInt(1, 10 + 1);

            builder.append("Du hast ").append(d10).append(" Schaden gewürfelt.");

            channel.sendMessage(builder.toString()).queue();
            return;
        }

        String goal = args.get(0);
        StringBuilder builder = new StringBuilder();

        try {
            int target = Integer.parseInt(goal);
            int d10 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            d10  = d10 + target;
            builder.append("Du hast ").append(d10).append(" Schaden gewürfelt,\n");

        } catch(Exception e) {
            builder.append("Schreib mal was richtiges bitte!");
        }

        channel.sendMessage(builder.toString()).queue();
    }

    @Override
    public String getName() {
        return "dmg";
    }

    @Override
    public String getHelp() {
        return "Rolls 1d10, and add n if given\n" +
                "Usage: `dmg @n`";
    }
}

