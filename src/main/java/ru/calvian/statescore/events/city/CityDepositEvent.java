package ru.calvian.statescore.events.city;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CityDepositEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();

    public CityDepositEvent() {

    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}
