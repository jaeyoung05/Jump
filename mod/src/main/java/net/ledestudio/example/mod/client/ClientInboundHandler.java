package net.ledestudio.example.mod.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import net.ledestudio.example.mod.charge.ConfirmationBoots;


import java.util.logging.Logger;

public class ClientInboundHandler extends ChannelInboundHandlerAdapter {

    public static Boolean isBoolean;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Logger.getLogger("Network").info("Channel Active");
    }



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            final int id = buf.readInt();
            if (id == 2){
                ConfirmationBoots boots = new ConfirmationBoots(buf);
                isBoolean = ConfirmationBoots.check;
                Logger.getLogger("gagagggagag").info(boots.toString());

            }

        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
