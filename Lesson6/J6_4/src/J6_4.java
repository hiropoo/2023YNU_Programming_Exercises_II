import p.ClassP;
import p1.p2.ClassP1P2;

public class J6_4 {
    public static void main(String[] args) {
        // オブジェクトを生成
        ClassP p = new ClassP();
        ClassP1P2 p1p2 = new ClassP1P2();

        // 各オブジェクトでクラス名を出力するメソッドを呼び出し
        p.print();
        p1p2.print();
    }
}
