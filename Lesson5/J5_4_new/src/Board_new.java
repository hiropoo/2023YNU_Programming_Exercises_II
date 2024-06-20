abstract class Board_new {
    // 3x3のボードを模した静的なchar型の配列
    static protected char[][] board = new char[3][3]; 

    // 3x3のマスに記号を置くための抽象メソッド
    abstract boolean put();

    // 全マスを'○'で初期化する静的メソッド
    static public void clear() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = '〇';
            }
        }
    }

    // 全マスの内容を表示する静的メソッド
    static public void print() {
        for(char[] row : board) {
            for(char col : row) {
                System.out.print(col);
            }

            // 行ごとに改行
            System.out.println("");   
        }

        // 3x3のボードごとに改行
        System.out.println(""); 
    }
    
}
