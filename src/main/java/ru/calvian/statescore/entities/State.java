package ru.calvian.statescore.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "states")
public class State {
    @Id
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "ideology")
    private String ideology;

    @ManyToOne
    private Balance balance;

    @ManyToOne
    @JoinColumn(name = "alliance_id", referencedColumnName = "id")
    private Alliance alliance;

    @OneToMany(mappedBy = "state")
    private List<City> cities;
}
