import java.util.InputMismatchException;
import java.util.Scanner;

public class J7_1 {
    public static void main(String[] args) {
        a();
        System.out.println("main : 終了");
    }

    static void a() {
        b();
    }

    static void b() {
        // スキャナーのインスタンスを生成
        Scanner sc = new Scanner(System.in);

        try {
            // 二つの整数を入力
            System.out.print("１つ目の整数を入力してください : ");
            int n1 = sc.nextInt();
            System.out.print("２つ目の整数を入力してください : ");
            int n2 = sc.nextInt(); 

            // 0 による除算で ArithmeticException が発生
            n1 = n1 / n2;
            
        } catch (ArithmeticException e) {
            // e.printStackTrace();
            // System.out.println(e);
            // System.out.println(e.getMessage());
            System.out.println("0で割っています");
            
        } catch (Exception e) {     // 上で拾いきれなかった例外の処理
            System.out.println(e);

        } finally {
            System.out.println("b : finally");
            sc.close();     // スキャナをクローズ
        }
    }
}
