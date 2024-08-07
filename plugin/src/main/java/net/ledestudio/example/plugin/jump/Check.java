package net.ledestudio.example.plugin.jump;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import static net.ledestudio.example.common.charge.server.ServerInboundHandler.gauge1;
import static net.ledestudio.example.common.charge.server.ServerInboundHandler.name;

public class Check {



    public void check(){

        Player player = Bukkit.getPlayer(name);

        if (player.getInventory().getBoots().getType() == Material.IRON_BOOTS){

            if (gauge1 == 0){

                player.sendMessage("charging");

            } else {

                Jump jump = new Jump();
                jump.superJump(player, gauge1);


            }


        } else {
            player.sendMessage("no");
        }
    }

}
