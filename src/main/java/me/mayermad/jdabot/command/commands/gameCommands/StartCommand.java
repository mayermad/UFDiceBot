package me.mayermad.jdabot.command.commands.gameCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

public class StartCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        TextChannel textChannel = ctx.getEvent().getGuild().getDefaultChannel();
        textChannel.sendMessage("@everyone Das Schicksal hat ein Auge auf euch geworfen.").tts(true).queue();
    }

    @Override
    public String getHelp() {
        return "bla";
    }

    @Override
    public String getName() {
        return "start";
    }
}
