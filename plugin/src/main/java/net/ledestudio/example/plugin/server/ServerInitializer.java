package net.ledestudio.example.plugin.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new ServerInboundHandler());
    }
}
