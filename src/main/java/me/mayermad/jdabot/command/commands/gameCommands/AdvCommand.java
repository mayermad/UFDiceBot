package me.mayermad.jdabot.command.commands.gameCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.storage.LiteSQL;
import me.mayermad.jdabot.storage.SQLManager;
import net.dv8tion.jda.api.entities.TextChannel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdvCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        StringBuilder builder = new StringBuilder();
        ResultSet resultSet;

        if (args.isEmpty()) {

            resultSet = LiteSQL.onQuery("SELECT id, name, advantage FROM advantages ORDER BY name");
            try {
                assert resultSet != null;
                builder.append("Name").append("\t\t").append("Advantage").append("\n");
                while (resultSet.next()) {
                    builder.append(resultSet.getString("name")).append("\t").append(resultSet.getInt("advantage")).append("\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            channel.sendMessage(builder.toString()).queue();
        }else if (args.get(0).equals("reset")) {
            SQLManager.reset();
        }else if (isInt(args.get(0))) {
            SQLManager.advPlayer(ctx.getAuthor().getId(), ctx.getAuthor().getAsMention(), Integer.parseInt(args.get(0)));
        }else {
            try {
                for (int i = 0; i < args.size()-1; i++){
                    builder.append(args.get(i)).append(" ");
                }
                String npcName = builder.toString();
                int adv = Integer.parseInt(args.get(args.size()-1));

                SQLManager.advNPC(npcName, adv);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getName() {
        return "adv";
    }

    @Override
    public String getHelp() {
        return "no help for you";
    }

    public static boolean isInt(String string) {
        if (string == null) {
            return false;
        }
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
