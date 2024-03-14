package ru.calvian.statescore.events.city;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class CitySetNameEvent extends AbstractEvent implements Cancellable {
    private final String name;
    private final Player player;

    public CitySetNameEvent(String name, Player player) {
        this.player = player;
        this.name = name;

    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
