package io.github.thetrouper.spaderacealias.events;

import io.github.thetrouper.spaderacealias.SpadeRaceAlias;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

import java.util.concurrent.atomic.AtomicInteger;

public class JumpPadEvents {

    public static void useLimePad(Player p) {
        Vector vec = new Vector(0,1.2,0);
        p.setVelocity(vec);
    }
    public static void useRedPad(Player p) {
        Vector vec = addFlatVelocity(p, 1.5);
        p.setVelocity(addUpVelocity(vec,0.9));
    }

    public static void useOrangePad(Player p) {
        AtomicInteger counter = new AtomicInteger(0);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(SpadeRaceAlias.getInstance(),() -> {
            if (counter.getAndDecrement() > 2) {
                Vector vec = addFlatVelocity(p,2);
                p.setVelocity(addUpVelocity(vec,1D));
            }
        },0,1);
    }
    public static Vector addFlatVelocity(Player p, double velocity) {
        double yaw = Math.toRadians(p.getLocation().getYaw());

        double xVelocity = -Math.sin(yaw) * velocity;
        double zVelocity = Math.cos(yaw) * velocity;

        return new Vector(xVelocity, p.getVelocity().getY(), zVelocity);
    }

    public static Vector addUpVelocity(Vector original, Double add) {
        Vector up = new Vector(0,add,0);
        return original.add(up);
    }
}
