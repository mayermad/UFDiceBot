package me.mayermad.jdabot.command.commands.characterCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.storage.LiteSQL;

import java.util.List;

public class SetStandardCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        String playerId = ctx.getAuthor().getId();
        try {
            String skill = args.get(0);
            String specialisation = args.get(1);
            LiteSQL.onUpdate("UPDATE standards SET "+ skill +" = " + specialisation + " WHERE discordId = \"" + playerId + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "setstandard";
    }

    @Override
    public String getHelp() {
        return null;
    }
}
