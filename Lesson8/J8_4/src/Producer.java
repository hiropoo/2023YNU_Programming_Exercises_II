public class Producer extends Thread {
    private Queue queue; // キューのインスタンス

    // コンストラクタ　キューを保存
    public Producer(Queue queue) {
        this.queue = queue;
    }

    // スレッド処理
    // Producerは、キューが空になったらキューがいっぱいになるまで書き込む処理を繰り返す
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            queue.write();
        }
    }
}
