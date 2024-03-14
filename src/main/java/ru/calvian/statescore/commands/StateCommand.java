package ru.calvian.statescore.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StateCommand extends AbstractCommand {

    public StateCommand() {
        super("state");
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
            case "alliance" -> alliance(args, player);
        }

    }

    private void name(String[] args, Player player) {

    }

    private void leader(String[] args, Player player) {

    }

    private void bank(String[] args, Player player) {

    }

    private void city(String[] args, Player player) {

    }

    private void ideology(String[] args, Player player) {

    }

    private void minister(String[] args, Player player) {

    }

    private void create(String[] args, Player player) {

    }

    private void destroy(String[] args, Player player) {

    }

    private void alliance(String[] args, Player player) {

    }

}
