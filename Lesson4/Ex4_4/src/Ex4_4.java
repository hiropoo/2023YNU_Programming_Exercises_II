import java.util.Random;

public class Ex4_4 {
    public static void main(String[] args) throws Exception {
        // 5人のテスト結果を扱うために5つのTestインスタンスを配列として宣言
        Test tests[] = new Test[5];

        // ランダムな数値の生成のためのRandomクラスのインスタンス
        Random rand = new Random(); 

        // 学籍番号とテストの結果をインスタンスに代入して初期化
        // テストの点数は、0 ~ 100 でランダムに生成
        for(int i = 0; i < tests.length; i++) {
            tests[i] = new Test(i+1, rand.nextInt(101), rand.nextInt(101), rand.nextInt(101));
        }

        // 5人全員の学籍番号、３教科の点数と合計、平均点を出力
        System.out.println("学籍番号 国語 数学 合計 平均");
        for(int i = 0; i < tests.length; i++) {
            // 学籍番号、国語、数学、合計を出力
            tests[i].print();
            // 平均を出力
            System.out.println(String.format("%10.6f", tests[i].average()));
        }

        // 総合計を出力
        System.out.println("総合計: " + Total.total(tests));

    }
}


