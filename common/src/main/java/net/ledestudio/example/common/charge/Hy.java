package net.ledestudio.example.common.charge;

import net.ledestudio.example.common.charge.server.ConfirmationBoots;
import net.ledestudio.example.common.charge.server.Server;


public class Hy {

    public void hey(boolean a){
        if (a){
            ConfirmationBoots confirmationShoes = new ConfirmationBoots(true);
            Server.sendPacket(confirmationShoes.toByteBuf());
        }

    }

}
