package ru.calvian.statescore.events.stateplayer;


import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.StatePlayer;

public class PlayerCityDeclineEvent extends Event {

    @Getter
    private final StatePlayer player;
    @Getter
    private final City city;

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public PlayerCityDeclineEvent(StatePlayer player, City city) {
        this.player = player;
        this.city = city;
    }
}
