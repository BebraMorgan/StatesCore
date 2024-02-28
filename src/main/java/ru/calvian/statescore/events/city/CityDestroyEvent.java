package ru.calvian.statescore.events.city;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.City;

@Getter
public class CityDestroyEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final City city;
    @Getter
    private final Player player;

    public CityDestroyEvent(City city, Player player) {
        this.city = city;
        this.player = player;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
