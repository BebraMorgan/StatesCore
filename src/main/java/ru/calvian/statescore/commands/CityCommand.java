package ru.calvian.statescore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.events.city.CityCreateEvent;
import ru.calvian.statescore.events.city.CityDepositEvent;
import ru.calvian.statescore.events.city.CityDestroyEvent;
import ru.calvian.statescore.events.city.CityWithdrawEvent;
import ru.calvian.statescore.repositories.CityRepository;
import ru.calvian.statescore.repositories.StatePlayerRepository;

public class CityCommand extends AbstractCommand {
    CityRepository cityRepository = new CityRepository();
    StatePlayerRepository playerRepository = new StatePlayerRepository(new StatePlayer());
    public CityCommand() {
        super("city");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return;
        Player player = ((Player) sender).getPlayer();
        if (args.length == 0) return;
        switch (args[0]) {
            case "create":
                create(player, args);
                break;
            case "destroy":
                destroy(player, args);
                break;
            case "bank":
                bank(player, args);
                break;
            case "name":
                name();
                break;
            case "resident":
                resident();
                break;
            case "mayor":
                mayor();
                break;
            case "alliance":
                alliance();
                break;
        }
//        if (args[0].equals("invite")) {
//            invite(sender, commandSender, args);
//        }
    }

    private void create(Player player, String[] args) {
        if (args.length < 2) return;
        Bukkit.getPluginManager().callEvent(new CityCreateEvent(args[1], player));
    }

    private void destroy(Player player, String[] args) {
        if (args.length < 2) return;
        City city = cityRepository.findByName(args[1]).get(0);
        Bukkit.getPluginManager().callEvent(new CityDestroyEvent(city, player));

    }

    private void bank(Player player, String[] args) {
        if (args.length < 3) return;
        String resource = args[1];
        String count = args[2];
        switch (args[1]) {
            case "withdraw":
                Bukkit.getPluginManager().callEvent(new CityWithdrawEvent(player, resource, count));
                break;
            case "deposit":
                Bukkit.getPluginManager().callEvent(new CityDepositEvent());
                break;
        }
    }

    private void name() {

    }

    private void resident() {

    }

    private void mayor() {

    }

    private void alliance() {

    }

//    private void invite(CommandSender sender, StatePlayer commandSender, String[] args) {
//        if (args.length == 2) return;
//        if (commandSender.getCity() == null) return;
//        StatePlayer player = repository.findByNick(args[1]).get(0);
//        if (player == null) return;
//        CityInviteEvent event = new CityInviteEvent(commandSender.getCity(), commandSender);
//        Bukkit.getPluginManager().callEvent(event);
//    }
}
