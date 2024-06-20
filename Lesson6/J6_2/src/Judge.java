public class Judge {
    // 勝敗の結果を表すクラス変数
    private static int result;
    
    // 引数のじゃんけんで出された手に対して、その勝敗を次の戻り値として返す
    // 勝ちの場合: 1, あいこの場合: 0, 負の場合: -1
    static int judge(int yourChoice, int comChoice) {
    
        // 勝敗を判断
        switch (yourChoice) {
            // あなたがグーを出した場合
            case 0:
                switch (comChoice) {
                    // あいこ
                    case 0:
                        result = 0;
                        break;
                    // 勝ち
                    case 1:
                        result = 1;
                        break;
                    // 負け
                    case 2:
                        result = -1;
                        break;
                }
                break;
            
            // あなたがチョキを出した場合
            case 1:
                switch (comChoice) {
                    // 負け
                    case 0:
                        result = -1;
                        break;
                    // あいこ
                    case 1:
                        result = 0;
                        break;
                    // 勝ち
                    case 2:
                        result = 1;
                        break;
                }
                break;

            // あなたがパーを出した場合
            case 2:
                switch (comChoice) {
                    // 勝ち
                    case 0:
                        result = 1;
                        break;
                    // 負け
                    case 1:
                        result = -1;
                        break;
                    // あいこ
                    case 2:
                        result = 0;
                        break;
                }
                break;
            
            default:
                break;
        }


        return result;
    }
    
}
