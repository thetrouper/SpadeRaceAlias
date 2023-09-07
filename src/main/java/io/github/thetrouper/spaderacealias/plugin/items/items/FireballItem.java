package io.github.thetrouper.spaderacealias.plugin.items.items;

import io.github.thetrouper.spaderacealias.plugin.builders.ItemBuilder;
import io.github.thetrouper.spaderacealias.plugin.items.CustomItem;
import io.github.thetrouper.spaderacealias.utils.Text;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class FireballItem extends CustomItem {

    public FireballItem() {
        super("fireball");
    }

    @Override
    public void buildItem(ItemBuilder builder) {
        builder.material(Material.FIRE_CHARGE);
        builder.name(Text.color("&6Fireball"));
        builder.lore(Text.color("&7- Right click to shoot!"));
    }

    @Override
    public void onInteract(Player player, Action action, ItemStack item, PlayerInteractEvent event) {
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            player.getWorld().spawn(player.getEyeLocation(), Fireball.class, entity -> {
                event.setCancelled(true);
                item.setAmount(item.getAmount() - 1);

                entity.setShooter(player);
                entity.setDirection(player.getLocation().getDirection());
                entity.setYield(0);
                entity.setBounce(false);
                entity.setVelocity(player.getLocation().getDirection().normalize().multiply(2));
            });
        }
    }
}
