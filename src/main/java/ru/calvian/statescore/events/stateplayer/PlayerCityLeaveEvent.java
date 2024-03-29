package ru.calvian.statescore.events.stateplayer;


import lombok.Getter;
import org.bukkit.entity.Player;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class PlayerCityLeaveEvent extends AbstractEvent {
    private final Player player;

    public PlayerCityLeaveEvent(Player player) {
        this.player = player;
    }
}
