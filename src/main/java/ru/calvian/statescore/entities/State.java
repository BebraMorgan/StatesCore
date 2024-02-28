package ru.calvian.statescore.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "states")
public class State {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "ideology")
    private String ideology;

    @ManyToOne
    private Balance balance;

    @OneToOne
    private StatePlayer leader;

    @OneToMany
    @JoinTable(name = "states_ministers")
    private List<StatePlayer> ministers;

    @ManyToOne
    @JoinColumn(name = "alliance", referencedColumnName = "id")
    private Alliance alliance;

    @OneToMany(mappedBy = "state")
    private List<City> cities;

    @OneToMany(mappedBy = "state")
    private List<StatePlayer> players;
}
