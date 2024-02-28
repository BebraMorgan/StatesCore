package ru.calvian.statescore.events.stateplayer;


import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.StatePlayer;

@Getter
public class PlayerCityLeaveEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final StatePlayer player;

    public PlayerCityLeaveEvent(StatePlayer player) {
        this.player = player;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}
