package ru.calvian.statescore.events.city;


import lombok.Getter;
import org.bukkit.entity.Player;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class CityStateJoinEvent extends AbstractEvent {
    private final Player player;
    private final String stateName;

    public CityStateJoinEvent(String stateName, Player player) {
        this.player = player;
        this.stateName = stateName;
    }
}
