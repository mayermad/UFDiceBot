package me.mayermad.jdabot.command.commands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MoneyCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        String goal = args.get(0);
        StringBuilder builder = new StringBuilder();

        try {
            int target = Integer.parseInt(goal);

            int sum = 0;

            builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat: (");
            for (int i = 1; i < target; i++){
                int d10 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
                sum += d10;
                builder.append(d10).append(" + ");
            }
            int d10 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            sum += d10;
            builder.append(d10);
            builder.append(") gewürfelt,\n (").append("Das sind insgesamt ").append(sum).append(")");

        } catch(Exception e) {
            builder.append("Ask Dev for usage...");
        }

        channel.sendMessage(builder.toString()).queue();
    }

    @Override
    public String getHelp() {
        return "TBA";
    }

    @Override
    public String getName() {
        return "d10";
    }
}
