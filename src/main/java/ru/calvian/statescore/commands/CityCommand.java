package ru.calvian.statescore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.events.city.CityInviteEvent;
import ru.calvian.statescore.repositories.StatePlayerRepository;

public class CityCommand extends AbstractCommand {
    public CityCommand() {
        super("city");
    }
    StatePlayerRepository repository = new StatePlayerRepository(new StatePlayer());

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return;
        StatePlayer commandSender = repository.findByNick(sender.getName()).get(0);
        if (args.length == 0) return;
        switch (args[0]) {
            case "create": create(); break;
            case "destroy": destroy(); break;
            case "bank": bank(); break;
            case "name": name(); break;
            case "resident": resident(); break;
            case "mayor": mayor(); break;
            case "alliance": alliance(); break;
        }
        if (args[0].equals("invite")) {
            invite(sender, commandSender, args);
        }
    }

    private void create() {

    }

    private void  destroy() {

    }

    private void bank() {

    }

    private void name() {

    }

    private void resident() {

    }

    private void mayor() {

    }

    private void alliance() {

    }

    private void invite(CommandSender sender, StatePlayer commandSender, String[] args) {
        if (args.length == 2) return;
        if (commandSender.getCity() == null) return;
        StatePlayer player = repository.findByNick(args[1]).get(0);
        if (player == null) return;
        CityInviteEvent event = new CityInviteEvent(commandSender.getCity(), commandSender);
        Bukkit.getPluginManager().callEvent(event);
    }
}
