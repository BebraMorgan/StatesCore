package ru.calvian.statescore.events.city;


import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.StatePlayer;

@Getter
public class CityInviteEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final City sender;
    @Getter
    private final StatePlayer receiver;

    public CityInviteEvent(City sender, StatePlayer receiver) {
        this.sender = sender;
        this.receiver = receiver;
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
