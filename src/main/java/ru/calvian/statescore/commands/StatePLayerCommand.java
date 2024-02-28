package ru.calvian.statescore.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.calvian.statescore.StatesCore;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.repositories.StatePlayerRepository;

public class StatePLayerCommand extends AbstractCommand {
    public StatePLayerCommand() {
        super("player");
    }

    private static final String DESCRIPTION = "usage: /player city <join/leave/decline>";

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return;
        StatePlayerRepository repository = new StatePlayerRepository(new StatePlayer());
        StatePlayer player = repository.findByNick(sender.getName()).get(0);
        if (StatesCore.getInstance().authenticate && player.getVkId() == null) {
            sender.sendMessage("без привязки вк нельзя вступить в город!");
            return;
        }
        if (args.length < 1) {
            sender.sendMessage(DESCRIPTION);
            return;
        }

        if (args[0].equals("join")) {
            join(args, sender, player);
        }
        if (args[0].equals("decline")) {
            decline(args, sender, player);
        }

        if (args[0].equals("leave")) {
            leave(args[1], player);
        }
    }

    private void decline(String[] args, CommandSender sender, StatePlayer player) {
//        if (args.length < 2) return;
//        player.getInvites().forEach(invite -> {
//            if (((CityInvite) invite).getSender().getName().equals(args[1])) {
//                invite.decline();
//            }
//        });
    }

    private void join(String[] args, CommandSender sender, StatePlayer player) {
//        if (args.length < 2) return;
//        player.getInvites().forEach(invite -> {
//            if (((CityInvite) invite).getSender().getName().equals(args[1])) {
//                invite.claim();
//            }
//        });
    }

    private void leave(String city, StatePlayer player) {
        if (player.getCity() == null) {
            return;
        }
        player.setCity(null);
    }
}
