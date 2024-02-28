package ru.calvian.statescore.events.city;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.City;

public class CityDestroyEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final City city;
    private final Player player;

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public CityDestroyEvent(City city, Player player) {
        this.city = city;
        this.player = player;
    }
}
