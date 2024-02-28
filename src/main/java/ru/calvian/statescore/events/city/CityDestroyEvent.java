package ru.calvian.statescore.events.city;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CityDestroyEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public CityDestroyEvent() {

    }
}
