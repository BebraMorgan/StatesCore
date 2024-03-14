package ru.calvian.statescore.repositories;

import ru.calvian.statescore.entities.Balance;

public class BalanceRepository extends BaseRepository<Balance> {
    public BalanceRepository() {
        super(new Balance());
    }
}
