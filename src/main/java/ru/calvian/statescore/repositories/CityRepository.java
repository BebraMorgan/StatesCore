package ru.calvian.statescore.repositories;

import ru.calvian.statescore.StatesCore;
import ru.calvian.statescore.entities.City;

import java.util.List;

public class CityRepository extends BaseRepository<City> {
    public CityRepository() {
        super(new City());
    }

    public List<City> findByName(String name) {
        return (List<City>) StatesCore.entityManager.createQuery("SELECT p FROM City p WHERE name = '" + name + "'").getResultList();
    }
}
