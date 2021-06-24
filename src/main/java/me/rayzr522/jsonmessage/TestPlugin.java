package me.rayzr522.jsonmessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final JSONMessage jsonMessage = JSONMessage.create("&6Hello " + player.getName());
        jsonMessage.actionbar(player);
        jsonMessage.title(20, 20, 20, player);
        jsonMessage.subtitle(player);
        jsonMessage.tooltip("this is a tooltip")
            .suggestCommand("/gae").send(player);
    }
}