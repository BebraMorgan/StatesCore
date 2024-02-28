package ru.calvian.statescore.events.city;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.StatePlayer;
@Getter
public class CityCreateEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final String name;
    private final double posX;
    private final double posY;
    private final StatePlayer creator;

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public CityCreateEvent(String name, double posX, double posY, StatePlayer creator) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.creator = creator;
    }
}
