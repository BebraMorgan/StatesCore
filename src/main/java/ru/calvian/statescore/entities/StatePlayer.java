package ru.calvian.statescore.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.calvian.statescore.entities.dictionaries.DictPlayerRoles;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "state_players")
public class StatePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private DictPlayerRoles role;

    private String nick;

    private String vkId;

    private int confirmed;

    @ManyToOne
    @JoinColumn(name = "state", referencedColumnName = "id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "id")
    private City city;
}

