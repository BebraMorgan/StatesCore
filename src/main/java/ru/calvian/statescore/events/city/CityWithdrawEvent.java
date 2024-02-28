package ru.calvian.statescore.events.city;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.repositories.StatePlayerRepository;

public class CityWithdrawEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final StatePlayer statePlayer;
    private final String resource;
    StatePlayerRepository playerRepository = new StatePlayerRepository(new StatePlayer());
    private int count;

    public CityWithdrawEvent(Player player, String resource, String count) {
        this.statePlayer = playerRepository.findByNick(player.getName()).get(0);
        this.resource = resource;
        try {
            this.count = Integer.parseUnsignedInt(count);
        } catch (NumberFormatException e) {
            this.count = 0;
        }
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}
