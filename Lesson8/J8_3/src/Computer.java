import java.util.Random;

public class Computer implements Runnable {
    // インスタンス変数
    private char symbol; // 置く記号
    private int numOfPutted = 0; // 置いた数
    private Board board; // Boardクラスインスタンス
    Random rd = new Random(); // スレッド処理ないで利用

    // コンストラクタ
    public Computer(char symbol, Board board) {
        this.symbol = symbol; // 記号を設定
        this.board = board; // Boardを設定
    }

    // 置いた数を返すゲッター
    public int getNumOfPutted() {
        return numOfPutted;
    }

    // スレッド処理
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 0 ~ 2 の乱数を発生
            int row = rd.nextInt(10);
            int col = rd.nextInt(10);

            // ボード board[row][col] に記号を配置
            // 100回連続で置けなければ終了
            if (board.put(row, col, this.symbol)) {
                this.numOfPutted++;
                i = 0; // 繰り返し回数のパラメータを初期化
                
                // [追加] sleep()メソッドにより一時停止
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
            }
        }
    }

}