public class Judge_new {

    // 勝敗の結果を表す配列
    // [あなたの手][相手の手]
    private static int[][] results = {
        {0, 1, -1},     // {[グー][グー], [グー][チョキ], [グー][パー]},
        {-1, 0, 1},     // {[チョキ][グー], [チョキ][チョキ], [チョキ][パー]},
        {1, -1, 0}      // {[パー][グー], [パー][チョキ], [パー][パー]}
    };;
    
    // 引数のじゃんけんで出された手に対して、その勝敗を次の戻り値として返す
    // 勝ちの場合: 1, あいこの場合: 0, 負の場合: -1
    static int judge(int yourChoice, int comChoice) {
        return results[yourChoice][comChoice];
    }
    
}