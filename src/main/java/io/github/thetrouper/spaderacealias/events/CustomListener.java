package io.github.thetrouper.spaderacealias.events;

import io.github.thetrouper.spaderacealias.SpadeRaceAlias;
import org.bukkit.event.Listener;

public interface CustomListener extends Listener {

    SpadeRaceAlias system = SpadeRaceAlias.getInstance();

    default CustomListener register() {
        return register(this);
    }

    static CustomListener register(CustomListener listener) {
        system.pm.registerEvents(listener, system);
        return listener;
    }
}
