package net.ledestudio.example.common.charge.check;

import net.ledestudio.example.common.charge.server.ConfirmationBoots;
import net.ledestudio.example.common.charge.server.Server;
import net.ledestudio.example.common.charge.server.ServerInboundHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.logging.Logger;

public class Boots {

    Player player = Bukkit.getPlayer(ServerInboundHandler.name);

    private boolean is;

    public boolean getIs() {
        return is;
    }

    public void setIs(boolean is) {
        this.is = is;
    }

    public void boots(){

        ItemStack itemStack = new ItemStack(Material.IRON_BOOTS);
        player.getInventory().setBoots(itemStack);

    }

    public void Check(boolean check){
        if (check) {



            if (player.getInventory().getBoots().getType() == Material.IRON_BOOTS){
                setIs(true);
            } else{
                setIs(false);
                player.sendMessage("you don't have boots");
            }

            ConfirmationBoots boots = new ConfirmationBoots(getIs());
            Server.sendPacket(boots.toByteBuf());
            Logger.getLogger("aaa").info(boots.toString());


        }

    }

    public void jump(boolean check, int gauge ){
        double up = gauge * 0.5;
        if (check && gauge > 0 && player.getInventory().getBoots().getType() == Material.IRON_BOOTS){
            player.setVelocity(new Vector(0, up,0));
        }
    }

}
