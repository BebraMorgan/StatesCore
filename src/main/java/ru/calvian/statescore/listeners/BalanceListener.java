package ru.calvian.statescore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.calvian.statescore.entities.Balance;
import ru.calvian.statescore.events.balance.DepositEvent;
import ru.calvian.statescore.events.balance.WithdrawEvent;
import ru.calvian.statescore.repositories.BalanceRepository;

public class BalanceListener implements Listener {
    private final BalanceRepository balanceRepository = new BalanceRepository();

    @EventHandler
    public void onDeposit(DepositEvent event) {
        try {
            int count = Integer.parseUnsignedInt(event.getCount());
            Balance balance = event.getBalance();
            switch (event.getResource()) {
                case "iron" -> balance.depositIron(count);
                case "diamond" -> balance.depositDiamond(count);
                case "netherite" -> balance.depositNetherite(count);
                default -> event.getPlayer().sendMessage("Неверные данные");
            }
            balanceRepository.update(balance);
            event.getPlayer().sendMessage("Депнули");
        } catch (NumberFormatException e) {
            event.getPlayer().sendMessage("Неверное значение");
        }
    }

    @EventHandler
    public void onWithdraw(WithdrawEvent event) {
        try {
            int count = Integer.parseUnsignedInt(event.getCount());
            Balance balance = event.getBalance();
            switch (event.getResource()) {
                case "iron" -> {
                    if (!balance.withdrawIron(count)) {
                        event.getPlayer().sendMessage("Недостаточно железа на балансе!");
                    }
                }
                case "diamond" -> {
                    if (!balance.withdrawDiamond(count)) {
                        event.getPlayer().sendMessage("Недостаточно алмазов на балансе!");
                    }
                }
                case "netherite" -> {
                    if (!balance.withdrawNetherite(count)) {
                        event.getPlayer().sendMessage("Недостаточно незерита на балансе!");
                    }
                }
                default -> event.getPlayer().sendMessage("Неверные данные");
            }
            balanceRepository.update(balance);
            event.getPlayer().sendMessage("Депнули");
        } catch (NumberFormatException e) {
            event.getPlayer().sendMessage("Неверное значение");
        }
    }
}
