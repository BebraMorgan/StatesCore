package ru.calvian.statescore.events.city;


import lombok.Getter;
import org.bukkit.entity.Player;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class CityStateLeaveEvent extends AbstractEvent {

    private final Player player;

    public CityStateLeaveEvent(Player player) {
        this.player = player;
    }
}
