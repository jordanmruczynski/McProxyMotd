package pl.jordii.mcmotd.listeners;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import pl.jordii.mcmotd.enums.MessagesProxy;
import pl.jordii.mcmotd.enums.MessagesManager;

import java.util.UUID;

public class MotdViewListener implements Listener {

    @EventHandler
    public void motdView(ProxyPingEvent e) {
        ServerPing ping = e.getResponse();
        ping.setVersion(new ServerPing.Protocol(MessagesManager.sendMessage(MessagesProxy.VERSION_LINE).replace("{ONLINE}", String.valueOf(ping.getPlayers().getOnline())), -1));
        ping.setDescription(MessagesManager.sendMessage(MessagesProxy.FIRST_LINE) + "\n" + MessagesManager.sendMessage(MessagesProxy.SECOND_LINE));
        ping.setPlayers(getAllServerPlayers());
        e.setResponse(ping);
    }

    public ServerPing.Players getAllServerPlayers(){
        int online = 1;
        int max = 2022;
        int i = 0;

        ServerPing.PlayerInfo[] players = new ServerPing.PlayerInfo[16];
        players[i++] = new ServerPing.PlayerInfo(" ", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("         §7MyLobby.pl", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("      §bWersja: 1.8.8", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo(" ", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("§3TeamSpeak3: §fmylobby", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("§5Discord: §fdc.mylobby.pl", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo(" ", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("  §3      _,           ,_", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("  §3    .'/    ,_      \\'.", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("  §3   |  \\__( >__/  |", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("  §3   \\            /", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("  §3    '-..__ __..-'", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("  §3          /_\\", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo(" ", UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo("§fAvaiable processors: §6" + Runtime.getRuntime().availableProcessors(), UUID.randomUUID());
        players[i++] = new ServerPing.PlayerInfo(" ", UUID.randomUUID());
        return new ServerPing.Players(max, ProxyServer.getInstance().getOnlineCount(), players);
    }

}
