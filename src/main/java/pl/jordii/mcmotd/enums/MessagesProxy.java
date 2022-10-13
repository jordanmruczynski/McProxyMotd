package pl.jordii.mcmotd.enums;

public enum MessagesProxy {
    VERSION_LINE("Motd.versionLine", "§bMcProxyMotd                          {ONLINE}/1337"),
    FIRST_LINE("Motd.firstLine", "§7Firstline"),
    SECOND_LINE("Motd.secondLine", "§7Second line");


    private String path;
    private String defaultMessage;

    MessagesProxy(String path, String defaultMessage) {
        this.path = path;
        this.defaultMessage = defaultMessage;
    }

    public String getPath() {
        return path;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
