package me.mayermad.jdabot.command.commands.characterCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.storage.SQLManager;

import java.util.List;

public class AddColumnCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        try{
            SQLManager.addColumn(args.get(0), args.get(1), Integer.parseInt(args.get(2)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getHelp() {
        return "adds column to table";
    }
}
