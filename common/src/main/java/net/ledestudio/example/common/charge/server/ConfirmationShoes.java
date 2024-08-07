package net.ledestudio.example.common.charge.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ConfirmationShoes {

    public static final int ID = 1;

    private int check;

    public ConfirmationShoes(int check) {
        this.check = check;
    }

    public ConfirmationShoes(ByteBuf buf){

        check = buf.readInt();

    }

    public ByteBuf toByteBuf() {
        ByteBuf buf = Unpooled.buffer();

        buf.writeInt(ID);

        buf.writeInt(check);

        return buf;
    }

    @Override
    public String toString() {
        return "ConfirmationShoes{" +
                "check=" + check +
                '}';
    }
}
