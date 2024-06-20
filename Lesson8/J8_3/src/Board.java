public class Board {
    // 3x3のボードを模したchar型の配列
    protected char[][] board = new char[10][10];

    // 全マスを'○'で初期化するインスタンスメソッド
    public void clear() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '〇';
            }
        }
    }

    // 全マスの内容を表示するインスタンスメソッド
    public void print() {
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col);
            }

            // 行ごとに改行
            System.out.println("");
        }

        // 3x3のボードごとに改行
        System.out.println("");
    }

    // 置く位置候補と置く記号を引数として、引数の場所に置けたらtrue、置けない場合はfalseを返す
    public synchronized boolean put(int i, int j, char c) {
        // 戻り値を表す変数
        boolean ret = true;
        
        // おける場合は、記号を置く
        if (board[i][j] == '〇') {
            board[i][j] = c;
        }
        // 置けない場合は、戻り値をfalseに設定し何もしない
        else {
            ret = false;
        }

        return ret;
    }

}