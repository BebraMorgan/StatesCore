package ru.calvian.statescore.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "DELETED = 0")
@Table(name = "cities")
public class City {
    @Id
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Balance balance;
    @Column(name = "name")
    private String name;
    @Column(name = "DELETED")
    private Integer deleted = 0;
    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private State state;
    @OneToMany(mappedBy = "city")
    private List<StatePlayer> players = new ArrayList<>();
    @Column(name = "x")
    private double x;
    @Column(name = "y")
    private double y;

    @OneToOne
    @JoinColumn(name = "mayor_id", referencedColumnName = "id")
    private StatePlayer mayor;
}
