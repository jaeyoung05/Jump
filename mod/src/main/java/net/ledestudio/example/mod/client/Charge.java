package net.ledestudio.example.mod.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;


public class Charge {

    public static final int ID = 1;


    private String name;
    private int gauge;
    private boolean isBoolean;

    public Charge(String name, int gauge, boolean isBoolean) {
        this.name = name;
        this.gauge = gauge;
        this.isBoolean = isBoolean;
    }

    public Charge(boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public Charge(ByteBuf buf){

        int length = buf.readInt();
        ByteBuf nameArr = buf.readBytes(length);
        name = nameArr.toString(StandardCharsets.UTF_8);

        gauge =buf.readInt();

        isBoolean = buf.readBoolean();
    }

    public  ByteBuf toByteBuf() {
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(ID);

        byte[] nameArr = name.getBytes(StandardCharsets.UTF_8);
        buf.writeInt(nameArr.length);
        buf.writeBytes(nameArr);

        buf.writeInt(gauge);

        buf.writeBoolean(isBoolean);
        return buf;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "name='" + name + '\'' +
                ", gauge=" + gauge +
                ", isBoolean=" + isBoolean +
                '}';
    }

    public double getGauge() {
        return gauge;
    }

    public boolean getBoolean() {
        return isBoolean;
    }

}
