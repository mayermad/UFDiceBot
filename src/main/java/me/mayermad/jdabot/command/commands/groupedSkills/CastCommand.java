package me.mayermad.jdabot.command.commands.groupedSkills;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.command.commands.gameCommands.AdvCommand;
import me.mayermad.jdabot.storage.SQLManager;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CastCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        StringBuilder builder = new StringBuilder();

        try {
            String argument;
            String zero = "0";
            List<String> arguments = new ArrayList<>(args);
            arguments.add(zero);
            builder.append(ctx.getEvent().getAuthor().getAsMention());
            int bonus = 0;
            if (!arguments.isEmpty()) {
                if (AdvCommand.isInt(arguments.get(0))) {
                    bonus = Integer.parseInt(arguments.get(0));
                } else if (AdvCommand.isInt(arguments.get(1))) {
                    argument = arguments.get(1);
                    bonus = Integer.parseInt(argument);
                }
            }
            int skill = SQLManager.getGroupedSkill("language", "magick", ctx.getAuthor().getId());
            if (skill == -1 ) {
                channel.sendMessage(ctx.getAuthor().getAsMention() + " du hast diesen Skill nicht gelernt!").queue();
                return;
            }
            int target = skill + SQLManager.getCharacteristic("int", ctx.getAuthor().getId());
            builder.append(" Dein Language (Magick) Skill ist ").append(target).append(". \n");
            int adv = SQLManager.getAdv(ctx.getAuthor().getId());
            if(adv > 0) {
                target = target + bonus + adv*10;
                builder.append("Zusammen mit deiner Advantage von ").append(adv).append(" würfelst du auf die ").append(target).append(".\n");
            } else if (bonus != 0) {
                target = target + bonus;
                builder.append("Mit dem Modifikator von ").append(bonus).append(" würfelst du auf die ").append(target).append(".\n");
            }
            int d100 = ThreadLocalRandom.current().nextInt(1, 100 + 1);

            int d00 = d100 / 10;
            int lvl = (target / 10) - d00;

            builder.append("Du hast eine ").append(d100).append(" gewürfelt,\n");

            if (target >= d100) {
                if (d100 % 10 == (d100 / 10) % 10) {
                    builder.append("!!! KRITISCHES CASTING !!!!!\n" +
                            "Würfel auf der Minor Miscast Tabelle und wähle einen der 3 Effecte:\n" +
                            "Critical Cast: If the spell causes Damage, it also inflicts a Critical Wound.\n" +
                            "Total Power: The spell is cast, no matter its CN and your rolled SL, but can be Dispelled.\n" +
                            "Unstoppable Force: If you scored enough SL to cast your spell, it cannot be Dispelled.");
                }
                builder.append("Du hast ").append(lvl).append(" Erfolgsgrade!");
            } else {
                if (d100 % 10 == (d100 / 10) % 10) {
                    builder.append("!!! KRITISCHES CASTING !!!!!\n" +
                            "Würfel auf der Minor Miscast Tabelle und wähle einen der 3 Effecte:\n" +
                            "Critical Cast: If the spell causes Damage, it also inflicts a Critical Wound.\n" +
                            "Total Power: The spell is cast, no matter its CN and your rolled SL, but can be Dispelled.\n" +
                            "Unstoppable Force: If you scored enough SL to cast your spell, it cannot be Dispelled.");
                }
                    builder.append("Du hast ").append(-1 * lvl).append(" Misserfolgsgrade!\n" +
                            "Würfel auf der Minor Miscast Tabelle!");
            }

        } catch (Exception e) {
            builder.append("Schreib mal was richtiges bitte!");
        }

        channel.sendMessage(builder.toString()).queue();
    }

    @Override
    public String getHelp() {
        return "nah";
    }

    @Override
    public String getName() {
        return "cast";
    }
}

