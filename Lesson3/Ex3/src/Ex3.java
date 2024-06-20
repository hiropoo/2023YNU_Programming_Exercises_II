import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {

        // StringBufferクラスのオブジェクトを初期値 "横浜学部学EP"で作成
        StringBuffer strb = new StringBuffer("横浜学部学EP");

        // 標準入力からの入力を受け取るスキャナ
        Scanner sc = new Scanner(System.in);

        // "国立大学理工"と"情報工/数理科"の入力を受け付け
        System.out.print("文字を入力してください: ");
        String str1 = sc.next();
        System.out.print("文字を入力してください: ");
        String str2 = sc.next();

        sc.close(); // スキャナをクローズ

        // 入力された文字をStringBufferクラスのオブジェクトに挿入
        strb.insert(strb.indexOf("学"), str1);
        strb.insert(strb.lastIndexOf("学"), str2);


        // 完成した文字列、文字数、StringBufferの容量を出力
        System.out.println("完成した文字列: " + strb);
        System.out.println("文字数: " + strb.length());
        System.out.println("容量: " + strb.capacity());

    }
}
