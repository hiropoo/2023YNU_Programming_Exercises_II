// テストの点数を扱うクラス
public class Test {
    // インスタンス変数
    int studentID;
    int JapScore;
    int EngScore;
    int mathScore;
    int totalScore;

    // コンストラクタ
    Test(int studentID, int JapScore, int  EngScore, int mathScore) {
        // インスタンス変数の初期化
        this.studentID = studentID;
        this.JapScore = JapScore;
        this.EngScore = EngScore;
        this.mathScore = mathScore;
        this.totalScore = this.sum();
    }


    // ３科目の合計点を計算するメソッド
    private int sum() {
        return this.JapScore + this.EngScore + this.mathScore;
    }

    // 合計点(totalScore)を返すゲッター
    public int getSum() {
        return this.totalScore;
    }

    // インスタンス変数を5つ出力するメソッド
    public void print() {
        System.out.printf("%7d %4d %4d %4d ", studentID, JapScore, EngScore, mathScore, totalScore);
    }

    // ３科目の平均点を計算し、戻り値とするメソッド
    public double average() {
        return (double)(JapScore + EngScore + mathScore) / 3;
    }
}


