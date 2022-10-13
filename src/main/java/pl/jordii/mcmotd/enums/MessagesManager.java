package pl.jordii.mcmotd.enums;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import pl.jordii.mcmotd.McMotd;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MessagesManager {
    private final File file;
    private ConfigurationProvider provider;
    private Configuration configuration;
    private static Map<MessagesProxy, String> messagesCache = new HashMap<>();

    public MessagesManager(McMotd plugin) {
        this.file = new File("plugins//" + plugin.getDescription().getName(), "messages.yml");
    }

    public void loadFile() throws IOException {
        File folder = this.file.getParentFile();
        if (!folder.exists()) {
            folder.mkdirs();
        }

        boolean created = this.file.createNewFile();

        this.provider = ConfigurationProvider.getProvider(YamlConfiguration.class);
        this.configuration = provider.load(this.file);

        if (created) {
            this.writeDefaults();
        }
        this.loadValues();
    }

    private void loadValues() throws IOException {
        this.configuration = provider.load(this.file);
        for (MessagesProxy messages : MessagesProxy.values()) {
            messagesCache.put(messages, this.configuration.getString(messages.getPath()));
        }
    }

    private void writeDefaults() throws IOException {
        for (MessagesProxy messages : MessagesProxy.values()) {
            this.configuration.set(messages.getPath(), messages.getDefaultMessage());
        }
        this.provider.save(this.configuration, this.file);
    }

    public static String sendMessage(MessagesProxy messages) {
        return messagesCache.get(messages);
    }
}
