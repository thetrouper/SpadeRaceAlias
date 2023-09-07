package io.github.thetrouper.spaderacealias.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class JumpPadEvents {

    public static void useLimePad(Player p) {
        Vector vec = new Vector(0,1.33,0);
        p.setVelocity(vec);
    }
    public static void useRedPad(Player p) {
        Location playerLocation = p.getLocation();
        Vector playerDirection = playerLocation.getDirection();
        playerDirection.normalize();
        Vector vec = playerDirection.multiply(1);
        Vector up = new Vector(0,1.33,0);
        Vector vecUp = vec.add(up);
        p.setVelocity(vecUp);
    }
}
