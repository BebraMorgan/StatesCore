package ru.calvian.statescore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.calvian.statescore.commands.utils.BalanceCommand;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.events.city.*;
import ru.calvian.statescore.repositories.StatePlayerRepository;

public class CityCommand extends AbstractCommand {
    private final StatePlayerRepository repository = new StatePlayerRepository();

    public CityCommand() {
        super("city");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return;
        Player player = ((Player) sender).getPlayer();
        if (args.length == 0) return;
        switch (args[0]) {
            case "create" -> create(args, player);
            case "destroy" -> destroy(player);
            case "bank" -> {
                StatePlayer statePlayer = repository.findByNick(player.getName()).get(0);
                new BalanceCommand(player, statePlayer.getCity().getBalance(), args).bank();
            }
            case "name" -> name(args, player);
            case "resident" -> resident(args, player);
            case "mayor" -> mayor(args, player);
            case "state" -> state(args, player);
        }
    }

    private void create(String[] args, Player player) {
        if (args.length < 2) return;
        Bukkit.getPluginManager().callEvent(new CityCreateEvent(args[1], player));
    }

    private void destroy(Player player) {
        Bukkit.getPluginManager().callEvent(new CityDestroyEvent(player));
    }

    private void name(String[] args, Player player) {
        if (args.length < 2) return;
        Bukkit.getPluginManager().callEvent(new CitySetNameEvent(args[1], player));
    }

    private void resident(String[] args, Player player) {
        if (args.length < 3) return;
        switch (args[1]) {
            case "invite" -> Bukkit.getPluginManager().callEvent(new CityInviteEvent(args[2], player));
            case "kick" -> Bukkit.getPluginManager().callEvent(new CityKickEvent(args[2], player));
        }
    }

    private void mayor(String[] args, Player player) {
        if (args.length < 2) return;
        Bukkit.getPluginManager().callEvent(new CitySetMayorEvent(args[1], player));
    }

    private void state(String[] args, Player player) {
        if (args.length < 3) return;
        switch (args[1]) {
            case "join" -> Bukkit.getPluginManager().callEvent(new CityStateJoinEvent(args[2], player));
            case "leave" -> Bukkit.getPluginManager().callEvent(new CityStateLeaveEvent(player));
        }
    }
}
