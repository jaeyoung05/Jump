package net.ledestudio.example.mod.charge;

import net.ledestudio.example.mod.client.Charge;
import net.ledestudio.example.mod.client.Client;

import static net.ledestudio.example.mod.ExampleMod.gauge;

public class Send {

    public void packet(String name, int gau, Boolean pressed){

        try {
            Client client = new Client("localhost", 1234);
            client.run();

            Charge charge = new Charge(name, gau , pressed );
            client.sendPacket(charge.toByteBuf());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
