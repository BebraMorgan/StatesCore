package ru.calvian.statescore.events.stateplayer;


import lombok.Getter;
import org.bukkit.entity.Player;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class PlayerCityJoinEvent extends AbstractEvent {
    private final Player player;
    private final String cityName;

    public PlayerCityJoinEvent(String cityName, Player player) {
        this.player = player;
        this.cityName = cityName;
    }
}
