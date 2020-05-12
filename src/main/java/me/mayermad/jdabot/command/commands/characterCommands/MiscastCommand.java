package me.mayermad.jdabot.command.commands.characterCommands;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MiscastCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        StringBuilder builder = new StringBuilder();
        try {
            int d100 = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            if (args.get(0).equalsIgnoreCase("minor")){
                
                    if (d100 <= 5) {
                        builder.append("Witchsign: the next living creature born within 1 mile is mutated.");
                    } else if (d100 <=10) {
                        builder.append("Soured Milk:All milk within 1d 100 yards goes sour instantly.");
                    } else if (d100 <=15) {
                        builder.append("Blight: Willpower Bonus fields within Willpower Bonus miles suffer a blight, and all crops rot overnight.");
                    } else if (d100 <=20) {
                        builder.append("Soulwax: Your ears clog instantly with a thick wax.Gain 1 Deafened Condition, which is not removed until someone  cleans them for you(with a successful use of the Heal Skill).");
                    } else if (d100 <=25) {
                        builder.append("Witchlight: You glow with an eerie light related to your Lore, emitting as much light as a large bonfire, which lasts for  1d 10 Rounds.");
                    } else if (d100 <=30) {
                        builder.append("Fell Whispers:Pass a Routine(+20) Willpower Test or gain 1 Corruption point.");
                    } else if (d100 <=35) {
                        builder.append("Rupture: Your nose, eyes, and ears bleed profusely.Gain 1d 10 Bleeding Conditions.");
                    } else if (d100 <=40) {
                        builder.append("Soulquake: Gain the Prone Condition.");
                    } else if (d100 <=45) {
                        builder.append("Unfasten: On your person, every buckle unfastens, and every lace unties, which may cause belts to fall, pouches to  open, bags to fall, and armour to slip.");
                    } else if (d100 <=50) {
                        builder.append("Wayward Garb:your clothes seem to writhe with a mind of their own.Receive 1 Entangled Condition with a  Strength of 1d 10×5 to resist.");
                    } else if (d100 <=55) {
                        builder.append("Curse of Temperance: All alcohol within 1d 100 yards goes bad, tasting bitter and foul.");
                    } else if (d100 <=60) {
                        builder.append("Souldrain: Gain 1 Fatigued Condition, which remains for 1d 10 hours.");
                    } else if (d100 <=65) {
                        builder.append("Driven to Distraction: If engaged in combat, gain the Surprised Condition.Otherwise, you are completely startled,  your heart racing, and unable to concentrate for a few moments.");
                    } else if (d100 <=70) {
                        builder.append("Unholy Visions:Fleeting visions of profane and unholy acts harass you.Receive a Blinded Condition; pass a  Challenging(+0) Cool Test or gain another.");
                    } else if (d100 <=75) {
                        builder.append("Cloying Tongue:All Language Tests(including Casting Tests) suffer a –10 penalty for 1d 10 Rounds.");
                    } else if (d100 <=80) {
                        builder.append("The Horror !:Pass a Hard(–20) Cool Test or gain 1 Broken Condition.");
                    } else if (d100 <=85) {
                        builder.append("Curse of Corruption: Gain 1 Corruption point.");
                    } else if (d100 <=90) {
                        builder.append("Double Trouble:The effect of the spell you cast occurs elsewhere within 1d 10 miles.At the GM’s discretion, where  possible it should have consequences.");
                    } else if (d100 <=95) {
                        builder.append("Multiplying Misfortune:Roll twice on this table, rerolling any results between 91 and 00.");
                    } else if (d100 <=100) {
                        builder.append("Cascading Chaos:Roll again on the Major Miscast Table");
                    }
                    channel.sendMessage(builder.toString()).queue();
            } else if (args.get(0).equalsIgnoreCase("major")){
                if (d100 <= 5) {
                    builder.append("Ghostly Voices: Everyone within Willpower yards hears darkly seductive whispering of voices emanating from " +
                            "the Realm of Chaos. All sentient creatures must pass an Average (+20) Cool Test or gain 1 Corruption point.");
                } else if (d100 <=10) {
                    builder.append("Hexeyes: Your eyes turn an unnatural colour associated with your Lore for 1d10 hours. While your eyes are " +
                            "discoloured, you have 1 Blinded Condition that cannot be resolved by any means.");
                } else if (d100 <=15) {
                    builder.append("Aethyric Shock: you suffer 1d10 wounds, ignoring your Toughness Bonus and Armour Points. Pass an Average " +
                            "(+20) Endurance Test, or also gain a Stunned Condition.");
                } else if (d100 <=20) {
                    builder.append("Death Walker: Your footsteps leave death in their wake. For the next 1d10 hours, any plant life near you withers " +
                            "and dies.");
                } else if (d100 <=25) {
                    builder.append("Intestinal Rebellion: Your bowels move uncontrollably, and you soil yourself. Gain 1 Fatigued Condition, " +
                            "which cannot be removed until you can change your clothes and clean yourself up.");
                } else if (d100 <=30) {
                    builder.append("Soulfire: Gain an Ablaze Condition, as you are wreathed in unholy flames with a colour associated with your " +
                            "Lore.");
                } else if (d100 <=35) {
                    builder.append("Speak in Tongues: You gabble unintelligibly for 1d10 rounds. During this time, you cannot communicate " +
                            "verbally, or make any Casting Tests, although you may otherwise act normally.");
                } else if (d100 <=40) {
                    builder.append("Swarmed: You are engaged by a swarm of aethyric Rats, Giant Spiders, Snakes, or similar (GM’s choice). Use " +
                            "the standard profiles for the relevant creature type, adding the Swarm Creature Trait. After 1d10 rounds, if not " +
                            "yet destroyed, the swarm retreats.");
                } else if (d100 <=45) {
                    builder.append("Ragdoll: You are flung 1d10 yards through the air in a random direction, taking 1d10 wounds on landing, " +
                            "ignoring Armour Points, and receiving the Prone Condition.");
                } else if (d100 <=50) {
                    builder.append("Limb frozen: One limb (randomly determined) is frozen in place for 1d10 hours. The limb is useless, as if it had " +
                            "been Amputated (see page 180).");
                } else if (d100 <=55) {
                    builder.append("Darkling Sight: You lose the benefit of the Second Sight Talent for 1d10 hours. Channelling Tests also suffer a " +
                            "penalty of –20 for the duration.");
                } else if (d100 <=60) {
                    builder.append("Chaotic Foresight: Gain a bonus pool of 1d10 Fortune points (this may take you beyond your natural limit). " +
                            "Every time you spend one of these points, gain 1 Corruption point. Any of these points remaining at the end of " +
                            "the session are lost.");
                } else if (d100 <=65) {
                    builder.append("Levitation: You are borne aloft on the Winds of Magic, floating 1d10 yards above the ground for 1d10 minutes. " +
                            "Other characters may forcibly move you, and you may move using spells, wings or similar, but will continually " +
                            "return to your levitating position if otherwise left alone. Refer to the Falling rules (see page 166) for what " +
                            "happens when Levitation ends.");
                } else if (d100 <=70) {
                    builder.append("Regurgitation: You spew uncontrollably, throwing up far more foul-smelling vomitus than your body can " +
                            "possibly contain. Gain the Stunned Condition, which lasts for 1d10 Rounds.");
                } else if (d100 <=75) {
                    builder.append("Chaos Quake: All creatures within 1d100 yards must pass an Average (+20) Athletics Test or gain the Prone " +
                            "Condition.");
                } else if (d100 <=80) {
                    builder.append("Traitor’s Heart: The Dark Gods entice you to commit horrendous perfidy. Should you attack or otherwise " +
                            "betray an ally to the full extent of your capabilities, regain all Fortune points. If you cause another character to " +
                            "lose a Fate Point, gain +1 Fate Point.");
                } else if (d100 <=85) {
                    builder.append("Foul Enfeeblement: Gain 1 Corruption point, the Prone Condition, and a Fatigued Condition");
                } else if (d100 <=90) {
                    builder.append("Hellish Stench: You now smell really bad! You gain the Distracting Creature Trait (see page 339), and probably " +
                            "the enmity of anyone with a sense of smell. This lasts for 1d10 hours.");
                } else if (d100 <=95) {
                    builder.append("Power Drain: You are unable to use the Talent used to cast the spell (usually Arcane Magic , though it could be " +
                            "Chaos Magic , or a similar Talent), for 1d10 minutes.");
                } else if (d100 <=100) {
                    builder.append("Aethyric Feedback: Everyone within a number of yards equal to your Willpower Bonus — friend and foe alike " +
                            "— suffers 1d10 wounds, ignoring Toughness Bonus and Armour Points, and receives the Prone Condition. If " +
                            "there are no targets in range, the magic has nowhere to vent, so your head explodes, killing you instantly.");
                }
                channel.sendMessage(builder.toString()).queue();
            }
        } catch (Exception e) {
            e.printStackTrace();
            channel.sendMessage("Minor oder Major?").queue();
            //minor or major?
        }
    }

    @Override
    public String getHelp() {
        return "bum";
    }

    @Override
    public String getName() {
        return "miscast";
    }
}
