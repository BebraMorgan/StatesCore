package ru.calvian.statescore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.calvian.statescore.StatesCore;

public class MainListener implements Listener {
    public MainListener() {
        StatesCore.getInstance().getServer().getPluginManager().registerEvents(new PlayerJoinListener(), StatesCore.getInstance());
    }
}
