package me.mayermad.jdabot.command.commands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.JDA;

public class PingCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();
        try {
            jda.wait(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jda.getRestPing().queue(
                (ping) -> ctx.getChannel()
                .sendMessageFormat("Wollen wir danach das exit game spielen?").queue()
        );
    }

    @Override
    public String getHelp() {
        return "Shows the current ping from the bot to the discord servers";
    }

    @Override
    public String getName() {
        return "ping";
    }
}
