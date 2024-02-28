package ru.calvian.statescore.events.stateplayer;


import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.StatePlayer;

public class PlayerCityLeaveEvent extends Event {

    @Getter
    private final StatePlayer player;

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public PlayerCityLeaveEvent(StatePlayer player) {
        this.player = player;
    }
}
