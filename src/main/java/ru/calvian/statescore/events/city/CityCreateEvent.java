package ru.calvian.statescore.events.city;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import ru.calvian.statescore.events.AbstractEvent;


@Getter
public class CityCreateEvent extends AbstractEvent implements Cancellable {
    private final String name;
    private final double posX;
    private final double posY;
    private final Player creator;

    public CityCreateEvent(String name, Player creator) {
        this.name = name;
        this.posX = creator.getLocation().getX();
        this.posY = creator.getLocation().getY();
        this.creator = creator;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
