package ru.calvian.statescore.listeners;

import org.bukkit.Bukkit;
import ru.calvian.statescore.StatesCore;
import ru.calvian.statescore.listeners.city.CityListenerLoader;
import ru.calvian.statescore.listeners.stateplayer.PlayerCityJoinListener;
import ru.calvian.statescore.listeners.stateplayer.PlayerCityLeaveListener;


public class ListenerLoader {
    public ListenerLoader() {
        new CityListenerLoader();
        Bukkit.getPluginManager().registerEvents(new PlayerCityJoinListener(), StatesCore.instance);
        Bukkit.getPluginManager().registerEvents(new PlayerCityLeaveListener(), StatesCore.instance);
        Bukkit.getPluginManager().registerEvents(new BalanceListener(), StatesCore.instance);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), StatesCore.instance);
    }
}
