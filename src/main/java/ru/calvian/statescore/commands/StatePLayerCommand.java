package ru.calvian.statescore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.calvian.statescore.events.stateplayer.PlayerCityJoinEvent;
import ru.calvian.statescore.events.stateplayer.PlayerCityLeaveEvent;

public class StatePLayerCommand extends AbstractCommand {
    public StatePLayerCommand() {
        super("player");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("Эту команду могут использовать только игроки.");
            return;
        }

        if (args.length < 1) {
            commandSender.sendMessage("Использование: /player <действие>");
            return;
        }

        switch (args[0]) {
            case "join":
                join(player, args);
                break;
            case "leave":
                leave(player);
                break;
            default:
                commandSender.sendMessage("Неверное действие. Доступные действия: join, leave");
        }
    }

    private void join(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Использование: /city join <город>");
            return;
        }
        Bukkit.getPluginManager().callEvent(new PlayerCityJoinEvent(args[1], player));
    }

    private void leave(Player sender) {
        Bukkit.getPluginManager().callEvent(new PlayerCityLeaveEvent(sender));
    }
}
