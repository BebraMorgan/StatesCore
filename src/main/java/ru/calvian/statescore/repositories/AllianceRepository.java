package ru.calvian.statescore.repositories;

import ru.calvian.statescore.entities.Alliance;

public class AllianceRepository extends BaseRepository<Alliance> {
    public AllianceRepository() {
        super(new Alliance());
    }
}
