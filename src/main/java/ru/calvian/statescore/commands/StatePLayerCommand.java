package ru.calvian.statescore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.events.stateplayer.PlayerCityJoinEvent;
import ru.calvian.statescore.events.stateplayer.PlayerCityLeaveEvent;
import ru.calvian.statescore.repositories.CityRepository;
import ru.calvian.statescore.repositories.StatePlayerRepository;

public class StatePLayerCommand extends AbstractCommand {
    public StatePLayerCommand() {
        super("player");
    }

    private static final String DESCRIPTION = "usage: /player city <join/leave/decline>";

    StatePlayerRepository playerRepository = new StatePlayerRepository(new StatePlayer());
    CityRepository cityRepository = new CityRepository();

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (!(commandSender instanceof Player)) return;
        StatePlayer sender = playerRepository.findByNick(commandSender.getName()).get(0);
        if (args.length < 1) {
            commandSender.sendMessage(DESCRIPTION);
            return;
        }
        switch (args[0]) {
            case "join":
                join(sender, args);
                break;
            case "leave":
                leave(sender);
                break;
        }
    }

    private void join(StatePlayer sender, String[] args) {
        if (args.length < 2) return;
        City city = cityRepository.findByName(args[2]).get(0);
        if (city == null) return;
        Bukkit.getPluginManager().callEvent(new PlayerCityJoinEvent(city, sender));
    }

    private void leave(StatePlayer sender) {
        Bukkit.getPluginManager().callEvent(new PlayerCityLeaveEvent(sender));
    }
}
