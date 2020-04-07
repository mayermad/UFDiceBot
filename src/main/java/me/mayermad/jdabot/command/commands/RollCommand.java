package me.mayermad.jdabot.command.commands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class RollCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        StringBuilder builder = new StringBuilder();

        String game = Objects.requireNonNull(ctx.getJDA().getPresence().getActivity()).getName();
        String goal;

        switch (game) {
            case "Warhammer Fantasy RPG":
                if (args.isEmpty()) {

                    int d100 = ThreadLocalRandom.current().nextInt(1, 100 + 1);

                    builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat eine ").append(d100).append(" gewürfelt.");
                    channel.sendMessage(builder.toString()).queue();
                    return;
                }

                goal = args.get(0);
                try {
                    int target = Integer.parseInt(goal);
                    int d100 = ThreadLocalRandom.current().nextInt(1, 100 + 1);

                    int d00 = d100 / 10;
                    int lvl = (target / 10) - d00;

                    builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat eine ").append(d100).append(" gewürfelt,\n");

                    if (target >= d100) {
                        if (d100 % 10 == (d100 / 10) % 10) {
                            builder.append("!!! KRITISCHER ERFOLG !!!!!");
                        } else {
                            builder.append("damit hast du ").append(lvl).append(" Erfolgsgrade!");
                        }

                    } else {
                        if (d100 % 10 == (d100 / 10) % 10) {
                            builder.append("!!! FATALER PATZER !!!");
                        } else {
                            builder.append("damit hast du ").append(-1 * lvl).append(" Misserfolgsgrade!");
                        }

                    }

                } catch (Exception e) {
                    builder.append("Schreib mal was richtiges bitte!");
                }

                channel.sendMessage(builder.toString()).queue();
                break;

            case "Only War":
            case "Dark Heresy":
                if (args.isEmpty()) {
                    int d100 = ThreadLocalRandom.current().nextInt(1, 100 + 1);

                    builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat eine ").append(d100).append(" gewürfelt.");
                    channel.sendMessage(builder.toString()).queue();
                    return;
                }

                goal = args.get(0);
                try {
                    int target = Integer.parseInt(goal);
                    int d100 = ThreadLocalRandom.current().nextInt(1, 100 + 1);

                    int lvl = (target - d100) / 10;

                    builder.append(ctx.getEvent().getAuthor().getAsMention()).append(" hat eine ").append(d100).append(" gewürfelt,\n");
                    if (d100 < 6) {
                        builder.append("!!! KRITISCHER ERFOLG !!!!!");
                    } else if (d100 > 94) {
                        builder.append("!!! FATALER PATZER !!!");
                    } else if (target >= d100) {
                        builder.append("damit hast du ").append(lvl).append(" Erfolgsgrade!");
                    } else {
                        builder.append("damit hast du ").append(-1 * lvl).append(" Misserfolgsgrade!");
                    }

                } catch (Exception e) {
                    builder.append("Schreib mal was richtiges bitte!");
                }

                channel.sendMessage(builder.toString()).queue();
                break;
            default:
                builder.append("Spiel ist noch nicht implementiert, oder noch kein Spiel ausgewählt");
                channel.sendMessage(builder.toString()).queue();
                break;
        }
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
