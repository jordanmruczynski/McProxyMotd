package pl.jordii.mcmotd.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import pl.jordii.mcmotd.McMotd;
import pl.jordii.mcmotd.enums.MessagesManager;

import java.io.IOException;
import java.util.Arrays;

public class ProxyMotdCommand extends Command {
    public ProxyMotdCommand() {
        super("mcmotd", "mcmotd.motd", new String[0]);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }
}
