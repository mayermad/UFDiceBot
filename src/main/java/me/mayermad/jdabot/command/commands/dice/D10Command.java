package me.mayermad.jdabot.command.commands.dice;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class D10Command implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();


        StringBuilder builder = new StringBuilder();
        boolean fails = true;
        int sum = 0;

        try {
            String goal = args.get(0);
            int target = Integer.parseInt(goal);

            builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat: (");
            for (int i = 1; i < target; i++){
                int d10 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
                sum += d10;
                builder.append(d10).append(", ");
            }
            int d10 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            sum += d10;
            builder.append(d10);
            builder.append(") gewürfelt,");

            try {
                String add = args.get(1);
                int bonus = Integer.parseInt(add);
                builder.append(" addiere ").append(bonus);
                sum += bonus;
            } catch (Exception ignored) {

            }
            builder.append("\n (").append("Das sind insgesamt ").append(sum).append(")");
            fails = false;
        } catch(Exception ignored) {

        }
        if (fails) {
            int d10 = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat eine ");
            builder.append(d10);
            builder.append(" gewürfelt.");
        }
        channel.sendMessage(builder.toString()).queue();
    }

    @Override
    public String getHelp() {
        return "Usage: `d10 @n @b` with `n = number of dice` and `b = bonus`";
    }

    @Override
    public String getName() {
        return "d10";
    }
}
