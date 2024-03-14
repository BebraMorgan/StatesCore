package ru.calvian.statescore.repositories;

import ru.calvian.statescore.StatesCore;
import ru.calvian.statescore.entities.CityInvite;

import java.util.List;

public class CityInviteRepository extends BaseRepository<CityInvite> {
    public CityInviteRepository() {
        super(new CityInvite());
    }

    public List<CityInvite> findByCity(int cityId) {
        return (List<CityInvite>) StatesCore.entityManager.createQuery("SELECT p FROM CityInvite p WHERE city_id = '" + cityId + "'").getResultList();
    }
}
