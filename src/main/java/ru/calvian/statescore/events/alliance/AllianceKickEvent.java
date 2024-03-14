package ru.calvian.statescore.events.alliance;


import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class AllianceKickEvent extends AbstractEvent implements Cancellable {
    private final Player sender;
    private final String receiver;

    public AllianceKickEvent(String receiver, Player sender) {
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
