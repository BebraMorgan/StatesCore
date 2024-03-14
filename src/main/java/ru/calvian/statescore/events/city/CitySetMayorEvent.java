package ru.calvian.statescore.events.city;


import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import ru.calvian.statescore.events.AbstractEvent;

@Getter
public class CitySetMayorEvent extends AbstractEvent implements Cancellable {
    private final Player sender;
    private final String nick;

    public CitySetMayorEvent(String nick, Player sender) {
        this.sender = sender;
        this.nick = nick;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
