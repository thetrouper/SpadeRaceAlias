package io.github.thetrouper.spaderacealias.events.listeners;

import io.github.thetrouper.spaderacealias.events.CustomListener;
import io.github.thetrouper.spaderacealias.events.JumpPadEvents;
import io.github.thetrouper.spaderacealias.utils.Cooldown;
import io.github.thetrouper.spaderacealias.utils.Text;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class JumpPadListener implements CustomListener {
    @EventHandler
    public void onDoubleJump(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Block standingOn = p.getLocation().clone().add(0,-1,0).getBlock();
        Block blockBelow = p.getLocation().clone().add(0,-2,0).getBlock();
        if (standingOn.getType().equals(Material.RED_CONCRETE)
            || standingOn.getType().equals(Material.ORANGE_CONCRETE)
            || standingOn.getType().equals(Material.LIME_CONCRETE)) {
            p.setAllowFlight(true);
        }
        if (p.isFlying() && p.getGameMode().equals(GameMode.ADVENTURE)) {
            p.setFlying(false);
            p.setAllowFlight(false);
            if (blockBelow.getType().equals(Material.RED_CONCRETE)) {
                JumpPadEvents.useRedPad(p);
            }
            if (blockBelow.getType().equals(Material.LIME_CONCRETE)) {
                JumpPadEvents.useLimePad(p);
            }
            if (blockBelow.getType().equals(Material.ORANGE_CONCRETE)) {
                JumpPadEvents.useOrangePad(p);
            }

        }
    }
}
