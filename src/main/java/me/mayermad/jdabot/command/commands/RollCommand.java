package me.mayermad.jdabot.command.commands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RollCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        if (args.isEmpty()) {
            StringBuilder builder = new StringBuilder();

            int d100 = ThreadLocalRandom.current().nextInt(1, 100 + 1);

            builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat eine ").append(d100).append(" gewürfelt.");

            channel.sendMessage(builder.toString()).queue();
            return;
        }

        String goal = args.get(0);
        StringBuilder builder = new StringBuilder();

        try {
            int target = Integer.parseInt(goal);
            int d100 = ThreadLocalRandom.current().nextInt(1, 100 + 1);

            int lvl = (target - d100)/10;

            builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat eine ").append(d100).append(" gewürfelt,\n");
            if (target > d100) {
                builder.append("damit hast du ").append(lvl).append(" Erfolgsgrade!");
            } else {
                builder.append("damit hast du ").append(-1 * lvl).append(" Misserfolgsgrade!");
            }

        } catch(Exception e) {
            builder.append("Schreib mal was richtiges bitte!");
        }

        channel.sendMessage(builder.toString()).queue();
    }

    @Override
    public String getHelp() {
        return "Rolls 1d100, and makes test against n if given\n" +
                "Usage: `roll @n`";
    }

    @Override
    public String getName() {
        return "roll";
    }
}
