package me.mayermad.jdabot.command.commands.characterCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.storage.SQLManager;

import java.util.List;

public class SetCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        int value = Integer.parseInt(args.get(1));
        SQLManager.setCharacteristic( args.get(0), ctx.getAuthor().getId(), value);
        SQLManager.setBasicSkill(args.get(0), ctx.getAuthor().getId(), value);

        ctx.getChannel().addReactionById(ctx.getMessage().getId(), "\uD83D\uDC4D").queue();
    }

    @Override
    public String getName() {
        return "set";
    }

    @Override
    public String getHelp() {
        return "setzt char wert";
    }
}
