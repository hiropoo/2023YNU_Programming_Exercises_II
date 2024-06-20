import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class J10_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // BufferedReader/Writerストリームを開く
            br = new BufferedReader(new FileReader("src/s10_2.txt"));
            bw = new BufferedWriter(new FileWriter("bin/d10_2.txt"));

            String data = null;
            while ((data = br.readLine()) != null) {
                // ファイルから一行読み取りStringBufferに保存
                StringBuffer strBuff = new StringBuffer(data);

                for (int i = 0; i < strBuff.length(); i++) {
                    int index = strBuff.indexOf("た", i); // i番目から最初の'た'の位置を保存

                    // 不要な'た'が存在した場合
                    if (index != -1) {
                        strBuff.deleteCharAt(index); // 'た'を削除
                        i = index;    // 探索位置を更新 ("たた"の削除防止)
                    }
                    // 存在しない場合
                    else {
                        break; // 探索終了
                    }
                }

                // 不要な'た'を削除した文字列を書き込む
                bw.write(strBuff.toString());
                bw.newLine();   // 改行
            }
            
            System.out.println("ファイルを作成しました");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        BufferedReader br2 = null;
        try {
            // BufferReaderを作成
            br2 = new BufferedReader(new FileReader("bin/d10_2.txt"));
            
            // ファイルから読み込んで、画面に表示
            String str = null;
            while ((str = br2.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br2 != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
