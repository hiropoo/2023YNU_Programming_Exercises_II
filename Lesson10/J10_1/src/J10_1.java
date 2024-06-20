import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class J10_1 {
    public static void main(String[] args) throws Exception {
        // FileReaderとFileWriterを宣言
        FileReader fr1 = null;
        FileReader fr2 = null;
        FileWriter fw = null;
        FileReader fr3 = null;

        try {
            // ファイルストリームを開く
            fr1 = new FileReader(args[0]);
            fr2 = new FileReader(args[1]);
            fw = new FileWriter(args[2]);

            // 読み取ったデータを保存する変数
            int dataA = -1;
            int dataB = -1;

            while (true) {
                // s10_1a.txtから一文字読み取る
                if ((dataA = fr1.read()) != -1) {
                    fw.write(dataA);
                }

                // s10_1b.txtから一文字読み取る
                if ((dataB = fr2.read()) != -1) {
                    fw.write(dataB);
                }

                // 両方とも読み取れなかった場合は終了
                if (dataA == -1 && dataB == -1) {
                    System.out.println(args[0] + ", " + args[1] + "から" + args[2] + "を作成しました\n");
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr1 != null)
                    fr1.close();
                if (fr2 != null)
                    fr2.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // 作成したファイルから読み込みと出力を行う
        try {
            fr3 = new FileReader(args[2]);
            System.out.println("作成したファイルの読み込み開始\n");
            int data = -1;
            while ((data = fr3.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();   // 改行
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr3 != null) fr3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
