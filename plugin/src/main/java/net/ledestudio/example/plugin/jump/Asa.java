package net.ledestudio.example.plugin.jump;

import org.bukkit.entity.Player;




import static net.ledestudio.example.common.charge.server.ServerInboundHandler.gauge1;

public class Asa {



    public static void player(Player player){

        player.sendMessage(String.valueOf(gauge1));

//        try {
//            Server server = new Server(1234);
//            server.run();
//
//            ConfirmationBoots shoes = new ConfirmationBoots();
//            server.sendPacket(shoes.toByteBuf());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
