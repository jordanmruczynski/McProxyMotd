package pl.jordii.mcmotd;

import net.md_5.bungee.api.plugin.Plugin;
import pl.jordii.mcmotd.commands.ProxyMotdCommand;
import pl.jordii.mcmotd.enums.MessagesManager;
import pl.jordii.mcmotd.listeners.MotdViewListener;

import java.io.IOException;

public final class McMotd extends Plugin {

    @Override
    public void onEnable() {
        try {
            new MessagesManager(this).loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getProxy().getPluginManager().registerListener(this, new MotdViewListener());
        getProxy().getPluginManager().registerCommand(this, new ProxyMotdCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
