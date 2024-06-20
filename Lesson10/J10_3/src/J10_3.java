import java.io.*;
import java.util.Random;

public class J10_3 {
    public static void main(String[] args) throws Exception {
        Random rd = new Random();

        // ファイルの生成と書き込み
        try (FileWriter textfw = new FileWriter("bin/d10_3.txt");
             DataOutputStream bindos = new DataOutputStream(new FileOutputStream("bin/d10_3.bin"))) {
                
            for (int i = 0; i < 10; i++) {
                // 一様なdouble型の乱数を発生
                double data = rd.nextDouble(); 

                // 発生したdouble型の乱数を書き込み
                textfw.write(Double.toString(data) + "\n");
                bindos.writeDouble(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        // ファイルサイズの表示
        File textFile = new File("bin/d10_3.txt");
        File binFile = new File("bin/d10_3.bin");
        System.out.println("Text File Size = " + textFile.length());
        System.out.println("Binary File Size = " + binFile.length());


        // ファイルの出力
        try (FileReader textfr = new FileReader("bin/d10_3.txt");
                DataInputStream bindis = new DataInputStream(new FileInputStream("bin/d10_3.bin"))) {
            // d10_3.txt の表示
            System.out.println("-----d10_3.txt-----");
            int data = -1;  // 読み取ったデータを保存
            while ((data = textfr.read()) != -1) {
                System.out.print((char)data);
            }

            // d10_3.bin の表示
            System.out.println("-----d10_3.bin-----");
            while (true) {
                System.out.println(bindis.readDouble());
            }

        } catch (EOFException eofe) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
