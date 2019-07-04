package br.com.guedesdesouza.server.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class MyServerSingleConnectionNetty {

    public MyServerSingleConnectionNetty(int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline()
                            .addLast(new ChannelInboundHandlerAdapter(){

                                private String request;

                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    if ("exit".equalsIgnoreCase(request)) {
                                        ctx.close();
                                    } else if ("hello".equalsIgnoreCase(request)) {
                                        ctx.writeAndFlush("Hi Boy!\n");
                                    }
                                }

                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    request = msg.toString();
                                    //super.channelRead(ctx, msg);
                                }


                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                    cause.printStackTrace();
                                    ctx.close();
                                }
                            });
                    }
                });

            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new MyServerSingleConnectionNetty(9000);
    }

}
