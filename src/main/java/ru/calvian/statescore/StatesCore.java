package ru.calvian.statescore;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.hibernate.jpa.HibernatePersistenceProvider;
import ru.calvian.statescore.commands.CityCommand;
import ru.calvian.statescore.commands.StatePLayerCommand;
import ru.calvian.statescore.listeners.ListenerLoader;

import javax.persistence.EntityManager;
import java.util.Collections;


@Getter
public final class StatesCore extends JavaPlugin implements Listener {

    public static StatesCore instance;
    public static EntityManager entityManager = new HibernatePersistenceProvider().createEntityManagerFactory("persistence", Collections.emptyMap()).createEntityManager();
    public boolean authenticate = false;

    @Override
    public void onEnable() {
        instance = this;
        new StatePLayerCommand();
        new CityCommand();
        new ListenerLoader();
        getServer().sendMessage(Component.text("Enabled!"));
    }


    @Override
    public void onDisable() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
