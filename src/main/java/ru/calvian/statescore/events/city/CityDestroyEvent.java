package ru.calvian.statescore.events.city;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class CityDestroyEvent extends AbstractEvent implements Cancellable {
    private final Player player;

    public CityDestroyEvent(Player player) {
        this.player = player;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
