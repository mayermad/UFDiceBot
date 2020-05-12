package me.mayermad.jdabot.command.commands.gameCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class AngMaCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        StringBuilder builder = new StringBuilder();
        try {
            float x = Float.valueOf(Double.toString(1 / Math.pow( 2, Integer.parseInt(args.get(0)))));
            double xx = 1/Math.pow(2, Integer.parseInt(args.get(0)));
            float f = (float) Math.sqrt(x*x + 1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getHelp() {
        return "nö";
    }

    @Override
    public String getName() {
        return "angma";
    }
}
