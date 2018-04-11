package extendThread.nio;

import sun.nio.ch.SelectionKeyImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Administrator on 2018/3/6.
 */
public class Server {

    public static void main(String[] args) throws Exception {
        Selector selector=Selector.open();
        ServerSocketChannel ssc=ServerSocketChannel.open();
        InetSocketAddress isa=new InetSocketAddress(9999);
        ssc.bind(isa);
        ssc.configureBlocking(false);
        SocketChannel sss= ssc.accept();

//        ByteBuffer readBuff=ByteBuffer.allocate(2028*5);
//        readBuff.clear();
//        sss.read(readBuff);
//        System.out.println(readBuff.position());
//        System.out.println("readBuff.remaining():" + readBuff.remaining());
//        byte[] b=new byte[readBuff.remaining()];
//        readBuff.position(0);
//        readBuff.get(b);
//        System.out.println("received blocking:"+new String(b));


//        ByteBuffer writeBuffered=ByteBuffer.allocate(1024 * 5);
//        writeBuffered.put("blocking".getBytes("utf-8"));
//        writeBuffered.flip();
//        sss.write(writeBuffered);
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer readBuffer=ByteBuffer.allocate(1024*5);
        ByteBuffer writeBuffer=ByteBuffer.allocate(1024*5);

        while(true){
            selector.select();
            Iterator<SelectionKey> i=selector.selectedKeys().iterator();
            while(i.hasNext()){
                SelectionKeyImpl sk=(SelectionKeyImpl)i.next();
                i.remove();
                if(sk.isValid()){
                    if(sk.isAcceptable()){
                        ServerSocketChannel ssc2=(ServerSocketChannel)sk.channel();
                        SocketChannel sc=ssc2.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                //        sc.register(selector,SelectionKey.OP_WRITE);

                    }

                    if(sk.isReadable()){
                        readBuffer.clear();
                        SocketChannel sc2=(SocketChannel)sk.channel();
                        int count=sc2.read(readBuffer);
                        if(count==-1){
                            sk.channel().close();
                            sk.cancel();
                            continue;
                        }

                        readBuffer.flip();
                        byte[] bytBuffer=new byte[readBuffer.remaining()];
                        readBuffer.get(bytBuffer);
                        String receiveStr=new String(bytBuffer);
                        System.out.println("received:"+receiveStr);
                        writeBuffer.clear();
                        writeBuffer.put(("I have received:" + receiveStr).getBytes("utf-8"));
                        writeBuffer.flip();
                        sc2.write(writeBuffer);

                    }

                    if(sk.isWritable()){
//                        System.out.println("OP_WRITE:"+SelectionKey.OP_WRITE+",binary:"+Integer.toBinaryString(SelectionKey.OP_WRITE));
//                        System.out.println("readyOps:"+sk.nioReadyOps()+",binary:"+Integer.toBinaryString(sk.nioReadyOps()));
//                        SocketChannel sc=(SocketChannel)sk.channel();
//                        writeBuffer.clear();
//                        writeBuffer.put("hi~~~~~".getBytes("gbk"));
//                        writeBuffer.flip();
//                        sc.write(writeBuffer);
                        System.out.println("in write");
                    }
                }
            }

        }
    }
}
