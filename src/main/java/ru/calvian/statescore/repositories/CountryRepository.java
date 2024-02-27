package ru.calvian.statescore.repositories;

import ru.calvian.statescore.entities.Country;

public class CountryRepository extends BaseRepository<Country> {
    public CountryRepository(Country model) {
        super(model);
    }
}
