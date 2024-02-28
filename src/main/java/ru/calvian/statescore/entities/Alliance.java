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
public class Alliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Balance balance;

    private String name;
    @OneToOne
    private State leader;

    @OneToMany(mappedBy = "alliance")
    private List<State> states;

}
