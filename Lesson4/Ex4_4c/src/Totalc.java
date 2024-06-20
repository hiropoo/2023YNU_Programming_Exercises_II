// Testクラスの配列を受け取り、全員の合計点を総合計するクラス
public class Totalc {
    // Test[]を引数として、総合計を求める静的メソッド
    public static int total(Testc[] tests) {
        // 総合計を保存するローカル変数
        int sum = 0;

        // [変更] ゲッターから合計点を取得
        for(int i = 0; i < tests.length; i++) {
            sum += tests[i].getTotalScore();
        }

        // 総合計を返す
        return sum;
    }

}