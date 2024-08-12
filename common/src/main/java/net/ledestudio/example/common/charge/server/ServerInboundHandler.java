package net.ledestudio.example.common.charge.server;


import com.google.common.collect.Maps;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import net.ledestudio.example.common.charge.Charge;
import net.ledestudio.example.common.charge.Hy;
import net.ledestudio.example.common.charge.check.Boots;


import java.util.Map;
import java.util.logging.Logger;

public class ServerInboundHandler extends ChannelInboundHandlerAdapter {

    public static int gauge1;
    public static boolean isBoolean;
    public static String name;
    public static String key;

    public static final Map<String, Channel> channelsMap = Maps.newConcurrentMap();

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        ServerInboundHandler.key = key;
    }

    public static boolean getIsBoolean() {
        return isBoolean;
    }

    public static void setIsBoolean(boolean isBoolean) {
        ServerInboundHandler.isBoolean = isBoolean;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Logger.getLogger("Network").info("Channel Active");

        Channel value = ctx.channel();
        setKey(ctx.channel().remoteAddress().toString());
        channelsMap.put(getKey(),value);

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        channelsMap.remove(getKey(),ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            final int id = buf.readInt();
            if (id == 1){
                Charge charge = new Charge (buf);
                Logger.getLogger("Network").info(charge.toString());
                gauge1 = charge.getGauge();
                setIsBoolean(charge.getBoolean());
                name = charge.getName();
                Logger.getLogger(name).info(String.valueOf(gauge1));
                Boots boots = new Boots();
                boots.Check(getIsBoolean());
                boots.jump(getIsBoolean(),gauge1);
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        channelsMap.remove(getKey(),ctx.channel());
        ctx.close();
    }
}
