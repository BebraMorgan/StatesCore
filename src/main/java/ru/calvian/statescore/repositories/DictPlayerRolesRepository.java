package ru.calvian.statescore.repositories;

import ru.calvian.statescore.StatesCore;
import ru.calvian.statescore.entities.dictionaries.DictPlayerRoles;

import java.util.List;

public class DictPlayerRolesRepository extends BaseRepository<DictPlayerRoles> {
    public DictPlayerRolesRepository() {
        super(new DictPlayerRoles());
    }

    public List<DictPlayerRoles> findByDescription(String nick) {
        return (List<DictPlayerRoles>) StatesCore.getInstance().getEntityManager().createQuery("SELECT p FROM DictPlayerRoles p WHERE description = '" + nick + "'").getResultList();
    }
}
