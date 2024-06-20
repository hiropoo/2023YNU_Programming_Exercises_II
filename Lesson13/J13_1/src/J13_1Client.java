import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

public class J13_1Client {
    private static Scanner sc;

    public static void main(String[] args) throws Exception {

        try {
            // ホスト名とポート番号を取得
            int port = Integer.parseInt(args[0]);   // ポート番号
            String serverName = args[1];              // ホスト名

            // ソケットを作成
            Socket socket = new Socket(serverName, port);
 
            // サーバーに書き込むためのストリームを作成
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            // サーバーに入力した数字を送信
            System.out.println("-----Client-----");
            dos.writeInt(getNum());
            dos.writeInt(getNum());

            // サーバーから読み取るためのストリームを作成
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            // サーバーから受け取った値をコンソールに出力
            System.out.println(dis.readInt() + "\n");

            socket.close();     // 切断
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ユーザーに数字を入力させてその数字を返す
    private static int getNum() {
        sc = new Scanner(System.in);
        System.out.print("num = ");
        int num = sc.nextInt();

        return num;
    }
}
