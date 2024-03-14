package ru.calvian.statescore.listeners.city;

import org.bukkit.Bukkit;
import ru.calvian.statescore.StatesCore;

public class CityListenerLoader {
    public CityListenerLoader() {
        Bukkit.getPluginManager().registerEvents(new CityCreateListener(), StatesCore.instance);
        Bukkit.getPluginManager().registerEvents(new CityDestroyListener(), StatesCore.instance);
        Bukkit.getPluginManager().registerEvents(new CityInviteListener(), StatesCore.instance);
    }
}
