package ru.calvian.statescore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.calvian.statescore.events.alliance.*;

public class AllianceCommand extends AbstractCommand {

    public AllianceCommand() {
        super("alliance");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return;
        Player player = ((Player) sender).getPlayer();
        if (args.length == 0) return;
        switch (args[0]) {
            case "create" -> create(args, player);
            case "destroy" -> destroy(args, player);
            case "bank" -> bank(args, player);
            case "name" -> name(args, player);
            case "leader" -> leader(args, player);
            case "state" -> state(args, player);
        }
    }

    private void create(String[] args, Player player) {
        if (args.length < 2) return;
        Bukkit.getPluginManager().callEvent(new AllianceCreateEvent(args[1], player));
    }

    private void destroy(String[] args, Player player) {
        if (args.length < 2) return;
        Bukkit.getPluginManager().callEvent(new AllianceDestroyEvent(args[1], player));
    }

    private void name(String[] args, Player player) {
        if (args.length < 2) return;
        Bukkit.getPluginManager().callEvent(new AllianceSetNameEvent(args[1], player));
    }

    private void bank(String[] args, Player player) {
        if (args.length < 3) return;
        String resource = args[1];
        String count = args[2];
        switch (args[1]) {
            case "withdraw" -> Bukkit.getPluginManager().callEvent(new AllianceWithdrawEvent(player, resource, count));
            case "deposit" -> Bukkit.getPluginManager().callEvent(new AllianceDepositEvent(player, resource, count));
        }
    }

    private void state(String[] args, Player player) {
        if (args.length < 3) return;
        switch (args[1]) {
            case "invite" -> Bukkit.getPluginManager().callEvent(new AllianceInviteEvent(args[2], player));
            case "kick" -> Bukkit.getPluginManager().callEvent(new AllianceKickEvent(args[2], player));
        }
    }

    private void leader(String[] args, Player player) {
        if (args.length < 2) return;
        Bukkit.getPluginManager().callEvent(new AllianceSetLeaderEvent(args[1], player));
    }

}
