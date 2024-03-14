package ru.calvian.statescore.listeners.city;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.calvian.statescore.entities.Balance;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.events.city.CityCreateEvent;
import ru.calvian.statescore.repositories.BalanceRepository;
import ru.calvian.statescore.repositories.CityRepository;
import ru.calvian.statescore.repositories.DictPlayerRolesRepository;
import ru.calvian.statescore.repositories.StatePlayerRepository;
import ru.calvian.statescore.utils.Messages;


public class CityCreateListener implements Listener {
    private final CityRepository cityRepository = new CityRepository();
    private final StatePlayerRepository playerRepository = new StatePlayerRepository();
    private final BalanceRepository balanceRepository = new BalanceRepository();

    @EventHandler
    public void onCityCreate(CityCreateEvent event) {
        City city = new City();
        StatePlayer mayor = playerRepository.findByNick(event.getCreator().getName()).get(0);
        Balance balance = new Balance();
        if (mayor.getCity() != null) {
            event.getCreator().sendMessage(String.format(Messages.ALREADY_IN_CITY, mayor.getCity().getName()));
            return;
        }
        city.setX(event.getPosX());
        city.setY(event.getPosY());
        city.setName(event.getName());
        mayor.setRole(new DictPlayerRolesRepository().find(3));
        city.setBalance(balance);
        balanceRepository.insert(balance);
        cityRepository.insert(city);
        city.setMayor(mayor);
        mayor.setCity(city);
        city.getPlayers().add(mayor);
        cityRepository.update(city);
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 0);
        }
        Bukkit.getServer().sendMessage(Component.text(String.format(Messages.CITY_CREATED, mayor.getNick(), city.getName())));
    }
}
