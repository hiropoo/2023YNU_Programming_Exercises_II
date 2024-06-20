public class J8_2 {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        ThreadX threads[] = new ThreadX[3];

        // CounterクラスのインスタンスをThreadXのインスタンス間で共有
        for (int i = 0; i < 3; i++) {
            threads[i] = new ThreadX(counter);
            threads[i].start(); // スレッドを開始
        }

        // 全てのスレッドが終わるのを待つ
        for (int i = 0; i < 3; i++) {
            threads[i].join();
        }

        System.out.println("カウント : " + counter.getCount());
    }
}


// Counterクラスを共有するスレッド
class ThreadX extends Thread {
    // 共有するCounterクラスのオブジェクト
    private Counter counter;

    // コンストラクタ counterクラスのインスタンスを受け取る
    ThreadX(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        // 10000回 Counterクラスの変数countをインクリメント
        for (int i = 0; i < 10000; i++) {
            counter.countUP();
        }
        
    }
}