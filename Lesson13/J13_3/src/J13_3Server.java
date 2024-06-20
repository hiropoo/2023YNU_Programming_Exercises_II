import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// 都道府県名と人口を保存するクラス
class Prefecture implements Serializable {
    static final long serialVersionUID = 1L;
    private String pref;
    private int population;

    Prefecture(String pref, int population) {
        this.pref = pref;
        this.population = population;
    }

    public String toString() {
        return pref + " : " + population;
    }
}

public class J13_3Server {
    private static HashMap<String, Prefecture> hash;

    public static void main(String[] args) {
        // 都道府県の人口データを保存するHashMapを作成
        makeHash();

        try {
            int port = Integer.parseInt(args[0]); // ポート番号を取得

            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                // クライアントからの要求を受け取る
                Socket socket = serverSocket.accept();

                // クライアントから読み取るためのストリームを作成
                InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);

                // キーを読み取る
                String key = ois.readUTF();

                // 読み取った値はコンソールに出力
                System.out.println("----- Server -----");
                System.out.println("key = " + key + "\n");

                // クライアントに書き込むためのストリームを作成
                OutputStream os = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);

                // keyに対応するHashMapの値をクライアントに送信
                oos.writeObject((Prefecture) searchHash(key));

                // 切断
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 都道府県の人口データを保存するHashMapを作成するメソッド
    private static void makeHash() {
        String[] pref = { "東京都", "神奈川県", "大阪府", "愛知県", "埼玉県", "千葉県", "兵庫" };
        int[] population = { 13161751, 9049500, 8862896, 7408499, 7194957, 6217119, 5589177 };
        String[] key = { "tokyo", "kanagawa", "osaka", "aichi", "saitama", "chiba", "hyogo" };
        Prefecture[] p = new Prefecture[pref.length];

        hash = new HashMap<String, Prefecture>();
        for (int i = 0; i < pref.length; i++) {
            p[i] = new Prefecture(pref[i], population[i]);
            hash.put(key[i], p[i]);
        }
    }

    // HashMapをキーで探索するメソッド
    // keyに対応する値があればその Prefectureオブジェクト を返し、
    // そうでなければ Prefecture("該当なし", 0) を返す
    private static Prefecture searchHash(String key) {
        Prefecture prefecture = new Prefecture("該当なし", 0); // 戻り値

        // keyに対応する都道府県があれば戻り値をそれに変更
        if (hash.containsKey(key)) {
            prefecture = hash.get(key);
        }

        return prefecture;
    }
}
