package ru.calvian.statescore.events.alliance;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class AllianceWithdrawEvent extends AbstractEvent implements Cancellable {
    private final Player player;
    private final String resource;
    private final String count;

    public AllianceWithdrawEvent(Player player, String resource, String count) {
        this.player = player;
        this.resource = resource;
        this.count = count;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
