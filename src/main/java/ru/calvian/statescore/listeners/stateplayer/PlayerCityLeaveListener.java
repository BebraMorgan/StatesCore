package ru.calvian.statescore.listeners.stateplayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.events.stateplayer.PlayerCityLeaveEvent;
import ru.calvian.statescore.repositories.CityRepository;
import ru.calvian.statescore.repositories.StatePlayerRepository;
import ru.calvian.statescore.utils.Messages;


public class PlayerCityLeaveListener implements Listener {
    private final CityRepository cityRepository = new CityRepository();
    private final StatePlayerRepository playerRepository = new StatePlayerRepository();

    @EventHandler
    public void onCityLeave(PlayerCityLeaveEvent event) {
        StatePlayer player = playerRepository.findByNick(event.getPlayer().getName()).get(0);
        City city = player.getCity();
        if (city == null) {
            event.getPlayer().sendMessage(Messages.NO_CITY);
            return;
        }
        city.getPlayers().remove(player);
        player.setCity(null);
        playerRepository.update(player);
        cityRepository.update(city);
    }
}
