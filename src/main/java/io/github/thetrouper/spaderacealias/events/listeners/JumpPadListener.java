package io.github.thetrouper.spaderacealias.events.listeners;

import io.github.thetrouper.spaderacealias.events.CustomListener;
import io.github.thetrouper.spaderacealias.events.JumpPadEvents;
import io.github.thetrouper.spaderacealias.utils.Cooldown;
import io.github.thetrouper.spaderacealias.utils.Text;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class JumpPadListener implements CustomListener {
    public static final Cooldown<Player> cooldown = new Cooldown<>();
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Block standingOn = p.getLocation().clone().add(0,-1,0).getBlock();
        if (standingOn.getType().equals(Material.LIME_CONCRETE)) {
            if (!cooldown.isOnCooldown(p)) {
                JumpPadEvents.useLimePad(p);
                cooldown.addCooldown(p,1000);
            }
        }
        if (standingOn.getType().equals(Material.RED_CONCRETE)) {
            if (!cooldown.isOnCooldown(p)) {
                JumpPadEvents.useRedPad(p);
                cooldown.addCooldown(p,1000);
            }
        }
    }
}
