package ru.calvian.statescore.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.calvian.statescore.entities.dictionaries.DictPlayerRoles;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "state_players")
public class StatePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @ManyToOne
    private DictPlayerRoles role;

    private String nick;
    @Column(name = "vk_id")
    private String vkId;

    private int confirmed;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne
    private Balance balance;

    public Player getPlayer() {
        return Bukkit.getPlayer(nick);
    }
}

