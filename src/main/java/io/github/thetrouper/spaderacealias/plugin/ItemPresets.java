package io.github.thetrouper.spaderacealias.plugin;

import io.github.thetrouper.spaderacealias.plugin.builders.ItemBuilder;
import io.github.thetrouper.spaderacealias.utils.Text;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public final class ItemPresets {

    public static final ItemStack EXAMPLE_ITEM = ItemBuilder.create()
            .material(Material.WOODEN_PICKAXE)
            .name(Text.color("&6Example &3Item"))
            .lore(Text.color("&7- This is an example item."))
            .flag(ItemFlag.HIDE_ENCHANTS)
            .enchant(Enchantment.MENDING, 1)
            .build();

}
