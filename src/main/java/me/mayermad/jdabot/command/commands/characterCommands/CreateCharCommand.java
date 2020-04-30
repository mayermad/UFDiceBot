package me.mayermad.jdabot.command.commands.characterCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.storage.SQLManager;

public class CreateCharCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        SQLManager.createChar(ctx.getAuthor().getId());
    }

    @Override
    public String getHelp() {
        return "erstellt char. Achtung nur einmal benutzen";
    }

    @Override
    public String getName() {
        return "createchar";
    }
}
