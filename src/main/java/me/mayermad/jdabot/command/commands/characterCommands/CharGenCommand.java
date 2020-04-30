package me.mayermad.jdabot.command.commands.characterCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.ThreadLocalRandom;

public class CharGenCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx){
        TextChannel channel = ctx.getChannel();
        StringBuilder builder = new StringBuilder();
        String race;

        int raceNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        if (raceNumber <= 90) {
            race = "Human";
        } else if (raceNumber <= 94) {
            race = "Halfling";
        } else if (raceNumber <= 98) {
            race = "Dwarf";
        } else if (raceNumber == 99) {
            race = "High Elf";
        } else {
            race = "Wood Elf";
        }

        int classNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        String career = "";
        int[] stats = new int[15];// 0move, 1ws, 2bs, 3s, 4t, 5i, 6ag, 7dex, 8in, 9wp, 10fel; 11wounds
        stats[1] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[2] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[3] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[4] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[5] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[6] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[7] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[8] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[9] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        stats[10] = ThreadLocalRandom.current().nextInt(1, 10 + 1) + ThreadLocalRandom.current().nextInt(1, 10 + 1);
        switch (race) {
            case "Human":
                stats[0] = 4;
                stats[1] += 20;
                stats[2] += 20;
                stats[3] += 20;
                stats[4] += 20;
                stats[5] += 20;
                stats[6] += 20;
                stats[7] += 20;
                stats[8] += 20;
                stats[9] += 20;
                stats[10] += 20;
                stats[11] = stats[3]/10 + (stats[4]/10)*2 + stats[9]/10;
                stats[12] = 2;
                stats[13] = 1;
                stats[14] = 3;
                if (classNumber <= 1) {
                    career = "Apothecary";
                } else if (classNumber <= 2) {
                    career = "Engineer";
                } else if (classNumber <= 3) {
                    career = "Lawyer";
                } else if (classNumber <= 5) {
                    career = "Nun";
                } else if (classNumber <= 6) {
                    career = "Physician";
                } else if (classNumber <= 11) {
                    career = "Priest";
                } else if (classNumber <= 13) {
                    career = "Scholar";
                } else if (classNumber <= 14) {
                    career = "Wizard";
                } else if (classNumber <= 15) {
                    career = "Agitator";
                } else if (classNumber <= 17) {
                    career = "Artisan";
                } else if (classNumber <= 19) {
                    career = "Beggar";
                } else if (classNumber <= 20) {
                    career = "Investigator";
                } else if (classNumber <= 21) {
                    career = "Merchant";
                } else if (classNumber <= 23) {
                    career = "Rat Catcher";
                } else if (classNumber <= 26) {
                    career = "Townsman";
                } else if (classNumber <= 27) {
                    career = "Watchman";
                } else if (classNumber <= 28) {
                    career = "Advisor";
                } else if (classNumber <= 29) {
                    career = "Artist";
                } else if (classNumber <= 30) {
                    career = "Duellist";
                } else if (classNumber <= 31) {
                    career = "Envoy";
                } else if (classNumber <= 32) {
                    career = "Noble";
                } else if (classNumber <= 35) {
                    career = "Servant";
                } else if (classNumber <= 36) {
                    career = "Spy";
                } else if (classNumber <= 37) {
                    career = "Warden";
                } else if (classNumber <= 38) {
                    career = "Bailiff";
                } else if (classNumber <= 39) {
                    career = "Hedge Witch";
                } else if (classNumber <= 40) {
                    career = "Herbalist";
                } else if (classNumber <= 42) {
                    career = "Hunter";
                } else if (classNumber <= 43) {
                    career = "Miner";
                } else if (classNumber <= 44) {
                    career = "Mystic";
                } else if (classNumber <= 45) {
                    career = "Scout";
                } else if (classNumber <= 50) {
                    career = "Villager";
                } else if (classNumber <= 51) {
                    career = "Bounty Hunter";
                } else if (classNumber <= 52) {
                    career = "Coachman";
                } else if (classNumber <= 54) {
                    career = "Entertainer";
                } else if (classNumber <= 56) {
                    career = "Flagellant";
                } else if (classNumber <= 57) {
                    career = "Messenger";
                } else if (classNumber <= 58) {
                    career = "Pedlar";
                } else if (classNumber <= 59) {
                    career = "Road Warden";
                } else if (classNumber <= 60) {
                    career = "Witch Hunter";
                } else if (classNumber <= 62) {
                    career = "Boatman";
                } else if (classNumber <= 63) {
                    career = "Huffer";
                } else if (classNumber <= 65) {
                    career = "Riverwarden";
                } else if (classNumber <= 68) {
                    career = "Riverwoman";
                } else if (classNumber <= 70) {
                    career = "Seaman";
                } else if (classNumber <= 71) {
                    career = "Smuggler";
                } else if (classNumber <= 73) {
                    career = "Stevedore";
                } else if (classNumber <= 74) {
                    career = "Wrecker";
                } else if (classNumber <= 76) {
                    career = "Bawd";
                } else if (classNumber <= 77) {
                    career = "Charlatan";
                } else if (classNumber <= 78) {
                    career = "Fence";
                } else if (classNumber <= 79) {
                    career = "Grave Robber";
                } else if (classNumber <= 83) {
                    career = "Outlaw";
                } else if (classNumber <= 84) {
                    career = "Racketeer";
                } else if (classNumber <= 87) {
                    career = "Thief";
                } else if (classNumber <= 88) {
                    career = "Witch";
                } else if (classNumber <= 90) {
                    career = "Cavalryman";
                } else if (classNumber <= 92) {
                    career = "Guard";
                } else if (classNumber <= 93) {
                    career = "Knight";
                } else if (classNumber <= 94) {
                    career = "Pit Fighter";
                } else if (classNumber <= 95) {
                    career = "Protagonist";
                } else if (classNumber <= 99) {
                    career = "Soldier";
                } else {
                    career = "Warrior Priest";
                }
                break;
            case "Halfling":
                stats[0] = 3;
                stats[1] += 10;
                stats[2] += 30;
                stats[3] += 10;
                stats[4] += 20;
                stats[5] += 20;
                stats[6] += 20;
                stats[7] += 30;
                stats[8] += 20;
                stats[9] += 30;
                stats[10] += 30;
                stats[11] = (stats[4]/10)*2 + stats[9]/10;
                stats[12] = 0;
                stats[13] = 2;
                stats[14] = 3;
                if (classNumber <= 1) {
                    career = "Apothecary";
                } else if (classNumber <= 2) {
                    career = "Engineer";
                } else if (classNumber <= 4) {
                    career = "Lawyer";
                } else if (classNumber <= 6) {
                    career = "Physician";
                } else if (classNumber <= 8) {
                    career = "Scholar";
                } else if (classNumber <= 10) {
                    career = "Agitator";
                } else if (classNumber <= 15) {
                    career = "Artisan";
                } else if (classNumber <= 19) {
                    career = "Beggar";
                } else if (classNumber <= 21) {
                    career = "Investigator";
                } else if (classNumber <= 25) {
                    career = "Merchant";
                } else if (classNumber <= 28) {
                    career = "Rat Catcher";
                } else if (classNumber <= 31) {
                    career = "Townsman";
                } else if (classNumber <= 33) {
                    career = "Watchman";
                } else if (classNumber <= 34) {
                    career = "Advisor";
                } else if (classNumber <= 36) {
                    career = "Artist";
                } else if (classNumber <= 37) {
                    career = "Envoy";
                } else if (classNumber <= 43) {
                    career = "Servant";
                } else if (classNumber <= 44) {
                    career = "Spy";
                } else if (classNumber <= 46) {
                    career = "Warden";
                } else if (classNumber <= 47) {
                    career = "Bailiff";
                } else if (classNumber <= 50) {
                    career = "Herbalist";
                } else if (classNumber <= 52) {
                    career = "Hunter";
                } else if (classNumber <= 53) {
                    career = "Miner";
                } else if (classNumber <= 54) {
                    career = "Scout";
                } else if (classNumber <= 57) {
                    career = "Villager";
                } else if (classNumber <= 58) {
                    career = "Bounty Hunter";
                } else if (classNumber <= 60) {
                    career = "Coachman";
                } else if (classNumber <= 63) {
                    career = "Entertainer";
                } else if (classNumber <= 65) {
                    career = "Messenger";
                } else if (classNumber <= 67) {
                    career = "Pedlar";
                } else if (classNumber <= 68) {
                    career = "Road Warden";
                } else if (classNumber <= 69) {
                    career = "Boatman";
                } else if (classNumber <= 70) {
                    career = "Huffer";
                } else if (classNumber <= 71) {
                    career = "Riverwarden";
                } else if (classNumber <= 74) {
                    career = "Riverwoman";
                } else if (classNumber <= 75) {
                    career = "Seaman";
                } else if (classNumber <= 79) {
                    career = "Smuggler";
                } else if (classNumber <= 82) {
                    career = "Stevedore";
                } else if (classNumber <= 85) {
                    career = "Bawd";
                } else if (classNumber <= 86) {
                    career = "Charlatan";
                } else if (classNumber <= 87) {
                    career = "Fence";
                } else if (classNumber <= 88) {
                    career = "Grave Robber";
                } else if (classNumber <= 89) {
                    career = "Outlaw";
                } else if (classNumber <= 90) {
                    career = "Racketeer";
                } else if (classNumber <= 94) {
                    career = "Thief";
                } else if (classNumber <= 96) {
                    career = "Guard";
                } else if (classNumber <= 97) {
                    career = "Pit Fighter";
                } else {
                    career = "Soldier";
                }
                break;
            case "Dwarf":
                stats[0] = 3;
                stats[1] += 30;
                stats[2] += 20;
                stats[3] += 20;
                stats[4] += 30;
                stats[5] += 20;
                stats[6] += 10;
                stats[7] += 30;
                stats[8] += 20;
                stats[9] += 40;
                stats[10] += 10;
                stats[11] = stats[3]/10 + (stats[4]/10)*2 + stats[9]/10;
                stats[12] = 0;
                stats[13] = 2;
                stats[14] = 2;
                if (classNumber <= 1) {
                    career = "Apothecary";
                } else if (classNumber <= 4) {
                    career = "Engineer";
                } else if (classNumber <= 6) {
                    career = "Lawyer";
                } else if (classNumber <= 7) {
                    career = "Physician";
                } else if (classNumber <= 9) {
                    career = "Scholar";
                } else if (classNumber <= 11) {
                    career = "Agitator";
                } else if (classNumber <= 17) {
                    career = "Artisan";
                } else if (classNumber <= 18) {
                    career = "Beggar";
                } else if (classNumber <= 20) {
                    career = "Investigator";
                } else if (classNumber <= 24) {
                    career = "Merchant";
                } else if (classNumber <= 25) {
                    career = "Rat Catcher";
                } else if (classNumber <= 31) {
                    career = "Townsman";
                } else if (classNumber <= 34) {
                    career = "Watchman";
                } else if (classNumber <= 36) {
                    career = "Advisor";
                } else if (classNumber <= 37) {
                    career = "Artist";
                } else if (classNumber <= 38) {
                    career = "Duellist";
                } else if (classNumber <= 40) {
                    career = "Envoy";
                } else if (classNumber <= 41) {
                    career = "Noble";
                } else if (classNumber <= 42) {
                    career = "Servant";
                } else if (classNumber <= 43) {
                    career = "Spy";
                } else if (classNumber <= 45) {
                    career = "Warden";
                } else if (classNumber <= 47) {
                    career = "Bailiff";
                } else if (classNumber <= 49) {
                    career = "Hunter";
                } else if (classNumber <= 54) {
                    career = "Miner";
                } else if (classNumber <= 55) {
                    career = "Scout";
                } else if (classNumber <= 56) {
                    career = "Villager";
                } else if (classNumber <= 60) {
                    career = "Bounty Hunter";
                } else if (classNumber <= 61) {
                    career = "Coachman";
                } else if (classNumber <= 63) {
                    career = "Entertainer";
                } else if (classNumber <= 65) {
                    career = "Messenger";
                } else if (classNumber <= 67) {
                    career = "Pedlar";
                } else if (classNumber <= 69) {
                    career = "Boatman";
                } else if (classNumber <= 70) {
                    career = "Huffer";
                } else if (classNumber <= 72) {
                    career = "Riverwoman";
                } else if (classNumber <= 73) {
                    career = "Seaman";
                } else if (classNumber <= 75) {
                    career = "Smuggler";
                } else if (classNumber <= 77) {
                    career = "Stevedore";
                } else if (classNumber <= 78) {
                    career = "Wrecker";
                } else if (classNumber <= 79) {
                    career = "Fence";
                } else if (classNumber <= 82) {
                    career = "Outlaw";
                } else if (classNumber <= 83) {
                    career = "Racketeer";
                } else if (classNumber <= 84) {
                    career = "Thief";
                } else if (classNumber <= 87) {
                    career = "Guard";
                } else if (classNumber <= 90) {
                    career = "Pit Fighter";
                } else if (classNumber <= 93) {
                    career = "Protagonist";
                } else if (classNumber <= 96) {
                    career = "Soldier";
                } else {
                    career = "Slayer";
                }
                break;
            case "High Elf":
                stats[0] = 5;
                stats[1] += 30;
                stats[2] += 30;
                stats[3] += 20;
                stats[4] += 20;
                stats[5] += 40;
                stats[6] += 30;
                stats[7] += 30;
                stats[8] += 30;
                stats[9] += 30;
                stats[10] += 20;
                stats[11] = stats[3]/10 + (stats[4]/10)*2 + stats[9]/10;
                stats[12] = 0;
                stats[13] = 0;
                stats[14] = 2;
                if (classNumber <= 2) {
                    career = "Apothecary";
                } else if (classNumber <= 6) {
                    career = "Lawyer";
                } else if (classNumber <= 8) {
                    career = "Physician";
                } else if (classNumber <= 12) {
                    career = "Scholar";
                } else if (classNumber <= 16) {
                    career = "Wizard";
                } else if (classNumber <= 19) {
                    career = "Artisan";
                } else if (classNumber <= 21) {
                    career = "Investigator";
                } else if (classNumber <= 26) {
                    career = "Merchant";
                } else if (classNumber <= 28) {
                    career = "Townsman";
                } else if (classNumber <= 29) {
                    career = "Watchman";
                } else if (classNumber <= 31) {
                    career = "Advisor";
                } else if (classNumber <= 32) {
                    career = "Artist";
                } else if (classNumber <= 34) {
                    career = "Duellist";
                } else if (classNumber <= 37) {
                    career = "Envoy";
                } else if (classNumber <= 40) {
                    career = "Noble";
                } else if (classNumber <= 43) {
                    career = "Spy";
                } else if (classNumber <= 45) {
                    career = "Warden";
                } else if (classNumber <= 47) {
                    career = "Herbalist";
                } else if (classNumber <= 50) {
                    career = "Hunter";
                } else if (classNumber <= 56) {
                    career = "Scout";
                } else if (classNumber <= 59) {
                    career = "Bounty Hunter";
                } else if (classNumber <= 62) {
                    career = "Entertainer";
                } else if (classNumber <= 63) {
                    career = "Messenger";
                } else if (classNumber <= 64) {
                    career = "Boatman";
                } else if (classNumber <= 79) {
                    career = "Seaman";
                } else if (classNumber <= 80) {
                    career = "Smuggler";
                } else if (classNumber <= 82) {
                    career = "Bawd";
                } else if (classNumber <= 85) {
                    career = "Charlatan";
                } else if (classNumber <= 88) {
                    career = "Outlaw";
                } else if (classNumber <= 92) {
                    career = "Cavalryman";
                } else if (classNumber <= 94) {
                    career = "Guard";
                } else if (classNumber <= 95) {
                    career = "Knight";
                } else if (classNumber <= 97) {
                    career = "Pit Fighter";
                } else if (classNumber <= 98) {
                    career = "Protagonist";
                } else {
                    career = "Soldier";
                }
                break;
            case "Wood Elf":
                stats[0] = 5;
                stats[1] += 30;
                stats[2] += 30;
                stats[3] += 20;
                stats[4] += 20;
                stats[5] += 40;
                stats[6] += 30;
                stats[7] += 30;
                stats[8] += 30;
                stats[9] += 30;
                stats[10] += 20;
                stats[11] = stats[3]/10 + (stats[4]/10)*2 + stats[9]/10;
                stats[12] = 0;
                stats[13] = 0;
                stats[14] = 2;
                if (classNumber <= 1) {
                    career = "Scholar";
                } else if (classNumber <= 5) {
                    career = "Wizard";
                } else if (classNumber <= 10) {
                    career = "Artisan";
                } else if (classNumber <= 14) {
                    career = "Advisor";
                } else if (classNumber <= 18) {
                    career = "Artist";
                } else if (classNumber <= 25) {
                    career = "Envoy";
                } else if (classNumber <= 31) {
                    career = "Noble";
                } else if (classNumber <= 35) {
                    career = "Spy";
                } else if (classNumber <= 42) {
                    career = "Herbalist";
                } else if (classNumber <= 52) {
                    career = "Hunter";
                } else if (classNumber <= 57) {
                    career = "Mystic";
                } else if (classNumber <= 68) {
                    career = "Scout";
                } else if (classNumber <= 70) {
                    career = "Bounty Hunter";
                } else if (classNumber <= 75) {
                    career = "Entertainer";
                } else if (classNumber <= 78) {
                    career = "Messenger";
                } else if (classNumber <= 79) {
                    career = "Wrecker";
                } else if (classNumber <= 85) {
                    career = "Outlaw";
                } else if (classNumber <= 90) {
                    career = "Cavalryman";
                } else if (classNumber <= 92) {
                    career = "Guard";
                } else if (classNumber <= 94) {
                    career = "Knight";
                } else if (classNumber <= 96) {
                    career = "Pit Fighter";
                } else {
                    career = "Soldier";
                }
                break;

        }
        builder.append(race).append("\t").append(career).append("\n");
        builder.append(formatMessage(stats));
        channel.sendMessage(builder.toString()).queue();
    }

    @Override
    public String getHelp() {
        return "jo";
    }

    @Override
    public String getName() {
        return "chargen";
    }

    private String formatMessage(int[] stats) {
        String output = "";
        output += "\nMov :\t " + stats[0];
        output += "\nWS  :\t" + stats[1];
        output += "\nBS    :\t" + stats[2];
        output += "\nS      :\t" + stats[3];
        output += "\nT      :\t" + stats[4];
        output += "\nI       :\t" + stats[5];
        output += "\nAg   :\t" + stats[6];
        output += "\nDex :\t" + stats[7];
        output += "\nInt   :\t" + stats[8];
        output += "\nWP :\t" + stats[9];
        output += "\nFel   :\t" + stats[10];
        output += "\nWounds :\t" + stats[11];
        output += "\nFate               :\t" + stats[12];
        output += "\nResilience     :\t" + stats[13];
        output += "\nExtra Points :\t" + stats[14];
        return output;
    }

}
