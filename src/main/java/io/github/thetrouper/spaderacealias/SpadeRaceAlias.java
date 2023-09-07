package io.github.thetrouper.spaderacealias;

import io.github.thetrouper.spaderacealias.commands.commands.ExampleCommand;
import io.github.thetrouper.spaderacealias.events.listeners.JumpPadListener;
import io.github.thetrouper.spaderacealias.events.listeners.RegistryListeners;
import io.github.thetrouper.spaderacealias.plugin.ConsoleTree;
import io.github.thetrouper.spaderacealias.plugin.items.items.FireballItem;
import io.github.thetrouper.spaderacealias.utils.Text;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.logging.Logger;

public final class SpadeRaceAlias extends JavaPlugin {

    public static final String prefix = Text.color("&9SpadeRace>&7 ");
    private static SpadeRaceAlias instance;
    public final PluginManager pm = Bukkit.getPluginManager();
    public final Logger logger = Bukkit.getLogger();
    public final BukkitScheduler scheduler = Bukkit.getScheduler();

    @Override
    public void onEnable() {
        instance = this;
        this.init();
        this.initConfig();

        String text = ConsoleTree.createTree()
                .title("Example Plugin Template")
                .subtitle("by ImproperIssues")
                .addProperty("property1", "value")
                .addProperty("property2", ConsoleTree.branch()
                        .addProperty("branch-property1", "value")
                        .addProperty("branch-property2", "value")
                        .addProperty("branch-property3", "value")
                        .addProperty("branch-property4", ConsoleTree.branch()
                                .addProperty("subbranch-property1", "value")
                                .addProperty("subbranch-property2", "value")
                                .build())
                        .build())
                .addProperty("property3", "value")
                .addProperty("Plugin Enabled", "true")
                .print();

        logger.info(text);
    }

    @Override
    public void onDisable() {

    }

    public void init() {
        // listeners
        new RegistryListeners().register();
        new JumpPadListener().register();

        // commands
        new ExampleCommand().register(); // registers commands

        // items
        new FireballItem().register();
    }

    public void initConfig() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    public static SpadeRaceAlias getInstance() {
        return instance;
    }
}
