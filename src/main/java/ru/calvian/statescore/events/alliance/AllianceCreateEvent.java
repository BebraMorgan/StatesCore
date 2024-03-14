package ru.calvian.statescore.events.alliance;

import org.bukkit.entity.Player;
import ru.calvian.statescore.events.AbstractEvent;

public class AllianceCreateEvent extends AbstractEvent {
    private final String name;
    private final Player player;

    public AllianceCreateEvent(String name, Player creator) {
        this.name = name;
        this.player = creator;
    }
}
