package me.mayermad.jdabot.command.commands.characterCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.storage.SQLManager;

import java.util.List;

public class GetCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        int value = 0;
        value = SQLManager.getCharacteristic(args.get(0),ctx.getAuthor().getId());
        if (value == -1) {
            value = SQLManager.getBasicSkill(args.get(0), ctx.getAuthor().getId());
            if (value == -1) {
                value = SQLManager.getAdvancedSkill(args.get(0), ctx.getAuthor().getId());
                if (value == -1) {
                    value = SQLManager.getGroupedSkill(args.get(0), args.get(1), ctx.getAuthor().getId());
                    if (value == -1) {
                        ctx.getChannel().sendMessage("Dein Wert ist entweder falsch geschrieben oder noch nicht implementiert.").queue();
                        return;
                    }
                }
            }
        }
        String output = ctx.getAuthor().getAsMention() + " dein " + args.get(0) + " Wert ist " + value;
        ctx.getChannel().sendMessage(output).queue();
    }

    @Override
    public String getHelp() {
        return "gets characteristic or skill advances";
    }

    @Override
    public String getName() {
        return "get";
    }
}
