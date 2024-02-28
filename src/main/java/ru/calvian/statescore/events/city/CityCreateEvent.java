package ru.calvian.statescore.events.city;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.repositories.StatePlayerRepository;

@Getter
public class CityCreateEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final StatePlayerRepository repository = new StatePlayerRepository(new StatePlayer());
    private final String name;
    private final double posX;
    private final double posY;
    private final StatePlayer creator;

    public CityCreateEvent(String name, Player creator) {
        StatePlayer player = repository.findByNick(creator.getName()).get(0);
        this.name = name;
        this.posX = creator.getLocation().getX();
        this.posY = creator.getLocation().getY();
        this.creator = player;
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
