package extendThread.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/3/6.
 */
public class Client {
    public static void main(String[] args) {
        InetSocketAddress isa=new InetSocketAddress("127.0.0.1",9999);
        ByteBuffer writeBuffer=ByteBuffer.allocate(1024*5);
        ByteBuffer readBuffer=ByteBuffer.allocate(1024*5);
        SocketChannel sc=null;
        try {
            sc=SocketChannel.open();
            sc.connect(isa);

            while (true){
                byte[] b=new byte[1024];
     //           System.in.read(b);
                writeBuffer.clear();
                writeBuffer.put("yoyo-client1".getBytes("utf-8"));
                writeBuffer.flip();
                sc.write(writeBuffer);
                readBuffer.clear();
                sc.read(readBuffer);
                readBuffer.flip();
                byte[] bArr=new byte[readBuffer.remaining()];
                readBuffer.get(bArr);
                System.out.println("receive:" + new String(bArr));
                TimeUnit.SECONDS.sleep(5);
            }

//            while (true){
//                readBuffer.clear();
//                sc.read(readBuffer);
//                readBuffer.flip();
//                byte[] bArr=new byte[readBuffer.remaining()];
//                readBuffer.get(bArr);
//                System.out.println("receive:" + new String(bArr, "utf-8"));
//                int ops=sc.validOps();
//                System.out.println("ops:"+ops+",binary:"+Integer.toBinaryString(ops));
//                TimeUnit.MINUTES.sleep(1);
//            }
        //    sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(sc!=null){
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
