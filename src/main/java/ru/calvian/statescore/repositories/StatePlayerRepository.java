package ru.calvian.statescore.repositories;

import ru.calvian.statescore.StatesCore;
import ru.calvian.statescore.entities.StatePlayer;

import java.util.List;

public class StatePlayerRepository extends BaseRepository<StatePlayer> {
    public StatePlayerRepository() {
        super(new StatePlayer());
    }

    public List<StatePlayer> findByNick(String nick) {
        return (List<StatePlayer>) StatesCore.entityManager.createQuery("SELECT p FROM StatePlayer p WHERE nick = '" + nick + "'").getResultList();
    }
}
