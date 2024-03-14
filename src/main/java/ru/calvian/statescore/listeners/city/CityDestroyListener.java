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
import ru.calvian.statescore.events.city.CityDestroyEvent;
import ru.calvian.statescore.repositories.BalanceRepository;
import ru.calvian.statescore.repositories.CityRepository;
import ru.calvian.statescore.repositories.DictPlayerRolesRepository;
import ru.calvian.statescore.repositories.StatePlayerRepository;
import ru.calvian.statescore.utils.Messages;


public class CityDestroyListener implements Listener {

    private final CityRepository cityRepository = new CityRepository();
    private final StatePlayerRepository playerRepository = new StatePlayerRepository();
    private final BalanceRepository balanceRepository = new BalanceRepository();

    @EventHandler
    public void onCityDestroy(CityDestroyEvent event) {
        StatePlayer statePlayer = playerRepository.findByNick(event.getPlayer().getName()).get(0);
        City city = statePlayer.getCity();
        if (city == null) {
            event.getPlayer().sendMessage(Messages.NO_CITY);
            return;
        }
        if (!city.getMayor().equals(statePlayer)) {
            event.getPlayer().sendMessage(Messages.NOT_MAYOR);
            return;
        }
        city.getMayor().setRole(new DictPlayerRolesRepository().find(1));

        city.getPlayers().forEach(player -> {
            player.setCity(null);
            playerRepository.update(player);
        });
        Bukkit.getServer().sendMessage(Component.text(String.format(Messages.CITY_DESTROYED, city.getName())));
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1, 0);
        }
        Balance balance = city.getBalance();
        cityRepository.delete(city);
        balanceRepository.delete(balance);
    }
}
