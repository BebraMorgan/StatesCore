package ru.calvian.statescore.repositories;


import ru.calvian.statescore.entities.State;

public class StateRepository extends BaseRepository<State> {
    public StateRepository() {
        super(new State());
    }
}
