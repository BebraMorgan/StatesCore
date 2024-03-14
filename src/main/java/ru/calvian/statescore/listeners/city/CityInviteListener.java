package ru.calvian.statescore.listeners.city;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.calvian.statescore.entities.CityInvite;
import ru.calvian.statescore.entities.StatePlayer;
import ru.calvian.statescore.events.city.CityInviteEvent;
import ru.calvian.statescore.repositories.CityInviteRepository;
import ru.calvian.statescore.repositories.StatePlayerRepository;
import ru.calvian.statescore.utils.Messages;

public class CityInviteListener implements Listener {
    private final StatePlayerRepository playerRepository = new StatePlayerRepository();
    private final CityInviteRepository inviteRepository = new CityInviteRepository();

    @EventHandler
    public void onCityInvite(CityInviteEvent event) {
        StatePlayer receiver = playerRepository.findByNick(event.getReceiver()).get(0);
        StatePlayer sender = playerRepository.findByNick(event.getSender().getName()).get(0);
        if (sender.getCity() == null) {
            event.getSender().sendMessage(Messages.NO_CITY);
            return;
        }
        if (!sender.getCity().getMayor().equals(sender)) {
            event.getSender().sendMessage(Messages.NOT_MAYOR);
            return;
        }
        if (receiver.getCity() != null) {
            event.getSender().sendMessage(String.format(Messages.PLAYER_ALREADY_IN_CITY, event.getReceiver()));
            return;
        }
        if (!inviteRepository.findByCity(sender.getCity().getId()).isEmpty()) {
            event.getSender().sendMessage(String.format(Messages.PLAYER_ALREADY_INVITED, event.getReceiver()));
            return;
        }
        CityInvite invite = new CityInvite();
        invite.setCity(sender.getCity());
        invite.setPlayer(receiver);
        inviteRepository.insert(invite);
        event.getSender().sendMessage(String.format(Messages.PLAYER_CITY_INVITED, event.getReceiver()));
        Bukkit.getPlayer(receiver.getNick()).sendMessage(String.format(Messages.YOU_WAS_INVITED, sender.getCity().getName(), sender.getCity().getName()));
    }
}
