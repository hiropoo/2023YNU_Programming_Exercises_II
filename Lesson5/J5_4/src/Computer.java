import java.util.Random;

public class Computer extends Board {
    // 記号用の変数を保存するインスタンス変数
    private char symbol;

    // 記号用の変数を初期化するコンストラクタ
    public Computer(char symbol) {
        this.symbol = symbol;
    } 

    @Override
    // 3x3のマス（board[][]）の空いているマスのうちランダムな箇所に記号を置くメソッド
    // どこにも置く場所がなかった場合は false を戻り値として返す  
    public boolean put() {
        Random rd = new Random();
        int randNum = -1;     // ランダムに決められた数(0 ~ 8)を保存
        int rowIndex = -1;    // 2次元配列boardの行のindex
        int colIndex = -1;    // 2次元配列boardの列のindex

        // ボードに記号を置くことができるかどうかを判断
        if(check()) {
            // 置くことができるならば、置ける場所が見つかるまで試行
            do {
                randNum = rd.nextInt(9);    // 0 ~ 8
                rowIndex = randNum / 3;     // 行のindex
                colIndex = randNum % 3;     // 列のindex
            } while(board[rowIndex][colIndex] != '〇');

            // 見つけた置ける場所に、記号（symbol）を代入
            board[rowIndex][colIndex] = symbol;

            return true;    // 置くことができたのでtrueを返す
        } else {
            return false;   // 置く場所がないのに呼ばれたのでfalseを返す
        }

    }

    // 3x3のボード上にまだ置ける場所が残っているか確認するメソッド
    // 置くことができればtrue, これ以上置く場所がなければfalseを返す
    private boolean check() {
        boolean flag = false;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                // 置くことができる場所があった時点で戻り値trueを確定させる
                if(board[i][j] == '〇') {
                    flag = true;
                    return flag;
                }
            }
        }

        return flag;
    }
}
