import java.io.*;
import java.util.ArrayList;

public class J10_4 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("src/s10_4.txt"))){
            // StreamTokenizerを作成
            StreamTokenizer st = new StreamTokenizer(br);

            // リストの作成 Playerインスタンスを保存
            ArrayList<Player> list = new ArrayList<>();

            // '/' を区切り文字に設定
            st.whitespaceChars('/', '/');
            st.whitespaceChars(',', ',');

            // EOL を有効化
            st.eolIsSignificant(true);

            // 読み取った値を保存する変数
            String position = null, name = null;
            int year = 0, month = 0, date = 0;
            
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                st.pushBack(); // 次に呼ばれるnextToken()では次の読み込みに移行しない
                
                // nvalCount, svalCount はそれぞれ nval と sval が一行ごとに何回呼ばれたかをカウント
                int nvalCount = 0;
                int svalCount = 0;

                // 一行ごとの処理
                while (st.nextToken() != StreamTokenizer.TT_EOL) {

                    switch (st.ttype) {
                        case StreamTokenizer.TT_NUMBER:
                            if (nvalCount == 0) {
                                year = (int) st.nval;
                                nvalCount++;
                            } else if (nvalCount == 1) {
                                month = (int) st.nval;
                                nvalCount++;
                            } else if (nvalCount == 2) {
                                date = (int) st.nval;
                                nvalCount = 0;
                            }
                            break;

                        case StreamTokenizer.TT_WORD:
                            if (svalCount == 0) {
                                position = st.sval;
                                svalCount++;
                            } else if (svalCount == 1) {
                                name = st.sval;
                                svalCount = 0;
                            }
                            break;
                    }

                }
                // リストにPlayerを追加
                list.add(new Player(position, name, year, month, date));
            }
            
            // Playerを表示
            for (Player player : list) {
                System.out.println(player);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
