package me.mayermad.jdabot;

import me.mayermad.jdabot.command.CommandContext;
import me.mayermad.jdabot.command.ICommand;
import me.mayermad.jdabot.command.commands.*;
import me.mayermad.jdabot.command.commands.basicSkills.*;
import me.mayermad.jdabot.command.commands.characterCommands.*;
import me.mayermad.jdabot.command.commands.characteristics.*;
import me.mayermad.jdabot.command.commands.dice.*;
import me.mayermad.jdabot.command.commands.gameCommands.*;
import me.mayermad.jdabot.command.commands.groupedSkills.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommandManager {
    private final List<ICommand> commands = new ArrayList<>();

    public CommandManager() {
        //basic commands
        addCommand(new PingCommand());
        addCommand(new HelpCommand(this));
        //game commands
        addCommand(new GameCommand());
        addCommand(new AdvCommand());
        //dice
        addCommand(new RollCommand());
        addCommand(new CoinCommand());
        addCommand(new Dmg2Command());
        addCommand(new DmgCommand());
        addCommand(new DxCommand());
        //Character commands
        addCommand(new CharGenCommand());
        //addCommand(new CreateCharCommand());
        addCommand(new SetCommand());
        addCommand(new GetCommand());
        //Characteristics
        addCommand(new WSCommand());
        addCommand(new BSCommand());
        addCommand(new SCommand());
        addCommand(new TCommand());
        addCommand(new IniCommand());
        addCommand(new AgCommand());
        addCommand(new DexCommand());
        addCommand(new IntCommand());
        addCommand(new WPCommand());
        addCommand(new FelCommand());
        //basic skills
        addCommand(new ArtCommand());
        addCommand(new AthleticsCommand());
        addCommand(new BriberyCommand());
        addCommand(new CharmAnimalCommand());
        addCommand(new CharmCommand());
        addCommand(new ClimbCommand());
        addCommand(new ConsumeAlcoholCommand());
        addCommand(new CoolCommand());
        addCommand(new DodgeCommand());
        addCommand(new DriveCommand());
        addCommand(new EnduranceCommand());
        addCommand(new EntertainCommand());
        addCommand(new GambleCommand());
        addCommand(new GossipCommand());
        addCommand(new HaggleCommand());
        addCommand(new IntimidateCommand());
        addCommand(new IntuitionCommand());
        addCommand(new LeadershipCommand());
        addCommand(new MeleeBasicCommand());
        addCommand(new MeleeCommand());
        addCommand(new NavigationCommand());
        addCommand(new OutdoorSurvivalCommand());
        addCommand(new PerceptionCommand());
        addCommand(new RideCommand());
        addCommand(new RowCommand());
        addCommand(new StealthCommand());
    }

    private void addCommand(ICommand cmd) {
        boolean nameFound = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(cmd.getName()));

        if (nameFound) {
            throw new IllegalArgumentException("A command with this name is already present");
        }

        commands.add(cmd);
    }

    public List<ICommand> getCommands() {
        return commands;
    }

    @Nullable
    public ICommand getCommand(String search) {
        String searchLower = search.toLowerCase();

        for (ICommand cmd : this.commands) {
            if (cmd.getName().equals(searchLower) || cmd.getAliases().contains(searchLower)) {
                return cmd;
            }
        }

        return null;
    }

    void handle(GuildMessageReceivedEvent event) {
        String[] split = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(Config.get("prefix")), "")
                .split("\\s+");

        String invoke = split[0].toLowerCase();
        ICommand cmd = this.getCommand(invoke);

        if (cmd != null) {
            event.getChannel().sendTyping().queue();
            List<String> args = Arrays.asList(split).subList(1, split.length);

            CommandContext ctx = new CommandContext(event, args);

            cmd.handle(ctx);
        }
    }

}
