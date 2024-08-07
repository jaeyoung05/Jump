package net.ledestudio.example.plugin.jump;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Boots {

    public void boots(Player player){
        ItemStack itemStack = new ItemStack(Material.IRON_BOOTS);
        player.getInventory().setBoots(itemStack);
    }

}
