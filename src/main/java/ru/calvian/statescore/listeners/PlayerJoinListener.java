package ru.calvian.statescore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.calvian.statescore.entities.Balance;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.entities.dictionaries.DictPlayerRoles;
import ru.calvian.statescore.repositories.DictPlayerRolesRepository;
import ru.calvian.statescore.repositories.StatePlayerRepository;

import java.util.List;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        StatePlayerRepository repository = new StatePlayerRepository();
        DictPlayerRolesRepository dictPlayerRolesRepository = new DictPlayerRolesRepository();
        DictPlayerRoles role = dictPlayerRolesRepository.find(1);
        Player player = event.getPlayer();
        List<StatePlayer> playerList = repository.findByNick(player.getName());
        if (playerList.isEmpty()) {
            StatePlayer statePlayer = new StatePlayer();
            statePlayer.setNick(player.getName());
            statePlayer.setRole(role);
            statePlayer.setBalance(new Balance());
            repository.insert(statePlayer);
        }
    }
}
