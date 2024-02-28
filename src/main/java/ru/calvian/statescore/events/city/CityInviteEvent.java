package ru.calvian.statescore.events.city;


import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.StatePlayer;

public class CityInviteEvent extends Event {

    @Getter
    private final City sender;
    @Getter
    private final StatePlayer receiver;

    private static final HandlerList HANDLERS = new HandlerList();
    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public CityInviteEvent(City sender, StatePlayer receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
}
