package ru.calvian.statescore;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.hibernate.jpa.HibernatePersistenceProvider;
import ru.calvian.statescore.commands.StatePLayerCommand;
import ru.calvian.statescore.listeners.PlayerJoinListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.logging.Logger;



public final class StatesCore extends JavaPlugin implements Listener {
    @Getter
    private static StatesCore instance;
    @Getter
    private EntityManager entityManager;

    public boolean authenticate = false;

    @Override
    public void onEnable() {
        instance = this;
        new StatePLayerCommand();
        Logger logger = Logger.getLogger("org.hibernate");
        logger.setParent(StatesCore.getInstance().getLogger());
        if (getServer().getPluginManager().getPlugin("StateVKAuth") != null) {
            authenticate = true;
        }
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        HibernatePersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = provider.createEntityManagerFactory("persistence", Collections.emptyMap());
        entityManager = entityManagerFactory.createEntityManager();
        getServer().sendMessage(Component.text("Enabled!"));
    }

    @Override
    public void onDisable() {
        if (entityManager != null) entityManager.close();
    }
}
