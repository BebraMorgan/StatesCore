package ru.calvian.statescore.listeners.stateplayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.CityInvite;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.events.stateplayer.PlayerCityJoinEvent;
import ru.calvian.statescore.repositories.CityInviteRepository;
import ru.calvian.statescore.repositories.CityRepository;
import ru.calvian.statescore.repositories.StatePlayerRepository;
import ru.calvian.statescore.utils.Messages;

public class PlayerCityJoinListener implements Listener {

    private final CityRepository cityRepository = new CityRepository();
    private final StatePlayerRepository playerRepository = new StatePlayerRepository();
    private final CityInviteRepository inviteRepository = new CityInviteRepository();

    @EventHandler
    public void onCityJoin(PlayerCityJoinEvent event) {
        City city = cityRepository.findByName(event.getCityName()).get(0);
        if (city == null) {
            event.getPlayer().sendMessage(Messages.CITY_NOT_FOUND);
            return;
        }
        CityInvite invite = inviteRepository.findByCity(city.getId()).get(0);
        if (invite == null) {
            event.getPlayer().sendMessage(Messages.CITY_NOT_INVITED);
            return;
        }
        StatePlayer player = playerRepository.findByNick(event.getPlayer().getName()).get(0);
        if (player.getCity() != null) {
            event.getPlayer().sendMessage(String.format(Messages.ALREADY_IN_CITY, player.getCity().getName()));
            return;
        }
        player.setCity(city);
        city.getPlayers().add(player);
        inviteRepository.delete(invite);
        playerRepository.update(player);
        cityRepository.update(city);
    }
}
