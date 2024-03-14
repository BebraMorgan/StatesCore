package ru.calvian.statescore.events.alliance;

import org.bukkit.entity.Player;
import ru.calvian.statescore.events.AbstractEvent;

public class AllianceSetLeaderEvent extends AbstractEvent {

    private final Player sender;
    private final String name;

    public AllianceSetLeaderEvent(String name, Player sender) {
        this.sender = sender;
        this.name = name;
    }
}
