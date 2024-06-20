import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class J13_2Server {
    public static void main(String[] args) {
        try {
            int port = Integer.parseInt(args[0]);

            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                // クライアントからの要求を受け取る
                Socket socket = serverSocket.accept();
                
                // クライアントから読み取るためのストリームを作成
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);

                // 数字を読み取る
                int num1 = dis.readInt();
                int num2 = dis.readInt();

                // 読み取った値はコンソールに出力
                System.out.println("----- Server -----");
                System.out.println("num1 = " + num1);
                System.out.println("num2 = " + num2);
                
                // クライアントに書き込むためのストリームを作成
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);

                // 読み取った2つの数字の和をクライアントに送信
                dos.writeInt(num1 + num2);

                // 切断
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
