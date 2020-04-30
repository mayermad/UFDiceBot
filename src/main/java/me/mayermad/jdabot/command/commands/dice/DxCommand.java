package me.mayermad.jdabot.command.commands.dice;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DxCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+");
        try {
            Matcher matcher = pattern.matcher(args.get(0));
            ArrayList<Integer> ints = new ArrayList<Integer>();
            while (matcher.find()) {
                ints.add(Integer.parseInt(matcher.group()));
            }
            builder.append(ctx.getEvent().getAuthor().getAsMention()).append("\t");
            for(int i = 0; i < ints.get(0); i++) {
                builder.append(ThreadLocalRandom.current().nextInt(1, ints.get(1) + 1)).append("\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
            builder.append("Da lief etwas schief");
        }
        channel.sendMessage(builder.toString()).queue();
    }

    @Override
    public String getHelp() {
        return "Nix";
    }

    @Override
    public String getName() {
        return "r";
    }
}
