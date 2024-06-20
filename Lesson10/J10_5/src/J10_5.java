import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class J10_5 {
    private static ArrayList<Player> list;

    public static void main(String[] args) throws Exception {
        // ArrayListを作成
        makeList();

        
        try (ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("bin/d10_5.obj"));
             ObjectInputStream objin = new ObjectInputStream(new FileInputStream("bin/d10_5.obj"))) {
            
            // listからPlayerインスタンスを取り出して、ファイルに書き込み
            for (int i = 0; i < list.size(); i++) {
                objout.writeObject(list.get(i));
            }

            // ファイルから読み取り、Playerインスタンスを画面に表示
            Player data = null;
            while ((data = (Player) objin.readObject()) != null) {
                System.out.println(data);
            }
        
        } catch (EOFException eofe) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // 課題４で作成したものと同様のlistを作成するメソッド
    private static void makeList() {
        try {
            // StreamTokenizerを作成
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(new FileReader("src/s10_5.txt")));

            // リストの作成 Playerインスタンスを保存
            list = new ArrayList<>();

            // '/' を区切り文字に設定
            st.whitespaceChars('/', '/');

            // EOL を有効化
            st.eolIsSignificant(true);

            // 読み取った値を保存する変数
            String position = null, name = null;
            int year = 0, month = 0, date = 0;
            
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                st.pushBack(); // 次に呼ばれるnextToken()では次の読み込みに移行しない
                
                // nvalNo, svalNo はそれぞれ nval と sval が一行ごとに何回呼ばれたかをカウント
                int nvalNo = 0;
                int svalNo = 0;

                // 一行ごとの処理
                while (st.nextToken() != StreamTokenizer.TT_EOL) {

                    switch (st.ttype) {
                        case StreamTokenizer.TT_NUMBER:
                            if (nvalNo == 0) {
                                year = (int) st.nval;
                                nvalNo++;
                            } else if (nvalNo == 1) {
                                month = (int) st.nval;
                                nvalNo++;
                            } else if (nvalNo == 2) {
                                date = (int) st.nval;
                                nvalNo = 0;
                            }
                            break;

                        case StreamTokenizer.TT_WORD:
                            if (svalNo == 0) {
                                position = st.sval;
                                svalNo++;
                            } else if (svalNo == 1) {
                                name = st.sval;
                                svalNo = 0;
                            }
                            break;
                    }

                }
                // リストにPlayerを追加
                list.add(new Player(position, name, year, month, date));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}