public class J8_3 {
    public static void main(String[] args) throws Exception {
        // 共有するBoardインスタンス
        Board board = new Board();
        board.clear(); // ボードをクリア

        // 3つのComputerインスタンスは、boardを共有する
        Computer[] computers = new Computer[3];
        computers[0] = new Computer('①', board);
        computers[1] = new Computer('②', board);
        computers[2] = new Computer('③', board);

        // スレッドを作成、開始
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(computers[i]);
            threads[i].start(); // スレッドを開始
        }

        // 全てのスレッドが終了するまで待機
        for (int i = 0; i < 3; i++) {
            threads[i].join();
        }

        // ボードのマスの内容を出力
        board.print();

        // 各スレッドがおいた数を出力
        int sum = 0; // 各スレッドがおいた数の合計を保存
        for (int i = 0; i < threads.length; i++) {
            System.out.println("Thread" + (i+1) +  " : " + computers[i].getNumOfPutted());
            sum += computers[i].getNumOfPutted();
        }
        System.out.println("合計 : " + sum); // 各スレッドがおいた数の合計を出力

    }
}
