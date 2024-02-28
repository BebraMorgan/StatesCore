package ru.calvian.statescore.repositories;

import org.checkerframework.checker.units.qual.C;
import ru.calvian.statescore.StatesCore;
import ru.calvian.statescore.entities.City;
import ru.calvian.statescore.entities.dictionaries.DictPlayerRoles;

import java.util.List;

public class CityRepository extends BaseRepository<City> {
    public CityRepository() {
        super(new City());
    }

    public List<City> findByName(String name) {
        return (List<City>) StatesCore.getInstance().getEntityManager().createQuery("SELECT p FROM City p WHERE name = '" + name + "'").getResultList();
    }
}
