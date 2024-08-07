package net.ledestudio.example.plugin.jump;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Jump {

    public void superJump(Player player, int y){
        player.setVelocity(new Vector(0, y, 0));
    }

}
