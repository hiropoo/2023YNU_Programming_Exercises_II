import java.util.InputMismatchException;
import java.util.Scanner;

public class J7_2 {
    public static void main(String[] args) {
        // 変数の宣言
        int n = 0;
        Scanner sc = new Scanner(System.in);

        try {
            try {
                // コマンドラインの第１引数をint型変数 n に代入
                n = Integer.parseInt(args[0]);

            } catch (ArrayIndexOutOfBoundsException e) {    // 引数がない場合: ArrayIndexOutOfBoundsException
                System.out.println(e);
                System.out.println("引数がありません");
                throw e;

            } catch (NumberFormatException e) {     // int型に変換できないとき: NumberFormatException
                System.out.println(e);
                System.out.println("int型ではありません");
                throw e;
            }

        } catch (Exception e) {     // 引数がない、もしくはint型に変換できないとき
            // int型変数 n が正しく入力されるまでループ処理
            while (true) {
                try {
                    System.out.println("int型を入力してください");
                    n = sc.nextInt();
                    break;

                } catch (InputMismatchException ee) {
                    // nextInt() のバッファを消去
                    sc.nextLine();
                }
            }
            
        } finally {
            sc.close();     // スキャナを閉じる
        }

        // n の値を出力
        System.out.println(n);
    }
}
