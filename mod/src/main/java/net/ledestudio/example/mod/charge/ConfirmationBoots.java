package net.ledestudio.example.mod.charge;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ConfirmationBoots {

    public static final int ID = 2;

    public static boolean check;

    public ConfirmationBoots(boolean check) {
        this.check = check;
    }

    public ConfirmationBoots(ByteBuf buf){

        check = buf.readBoolean();

    }

    public ByteBuf toByteBuf() {
        ByteBuf buf = Unpooled.buffer();

        buf.writeInt(ID);

        buf.writeBoolean(check);

        return buf;
    }

    @Override
    public String toString() {
        return "ConfirmationBoots{" +
                "check=" + check +
                '}';
    }
}
