package me.mayermad.jdabot.command.commands.advancedSkills;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.storage.SQLManager;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalCareCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        StringBuilder builder = new StringBuilder();

        String argument;
        try {
            builder.append(ctx.getEvent().getAuthor().getAsMention());
            int bonus = 0;
            if (!args.isEmpty()) {
                argument = args.get(0);
                bonus = Integer.parseInt(argument);
            }
            int skill = SQLManager.getAdvancedSkill("animalCare", ctx.getAuthor().getId());
            if (skill == -1 ) {
                channel.sendMessage(ctx.getAuthor().getAsMention() + " du hast diesen Skill nicht gelernt!").queue();
                return;
            }
            int target = skill + SQLManager.getCharacteristic("int", ctx.getAuthor().getId());
            builder.append(" Dein Animal Care Skill ist ").append(target).append(". \n");
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
                    builder.append("!!! KRITISCHER ERFOLG !!!!!");
                } else {
                    builder.append("damit hast du ").append(lvl).append(" Erfolgsgrade!");
                }

            } else {
                if (d100 % 10 == (d100 / 10) % 10) {
                    builder.append("!!! FATALER PATZER !!!");
                } else {
                    builder.append("damit hast du ").append(-1 * lvl).append(" Misserfolgsgrade!");
                }

            }

        } catch (Exception e) {
            builder.append("Schreib mal was richtiges bitte!");
        }

        channel.sendMessage(builder.toString()).queue();
    }

    @Override
    public String getName() {
        return "animalcare";
    }

    @Override
    public String getHelp() {
        return "jo";
    }
}
