package ru.calvian.statescore.events.stateplayer;


import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.StatePlayer;

@Getter
public class PlayerCityJoinEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final StatePlayer player;
    @Getter
    private final City city;

    public PlayerCityJoinEvent(City city, StatePlayer player) {
        this.player = player;
        this.city = city;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}
