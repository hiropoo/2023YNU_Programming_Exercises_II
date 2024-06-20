class Consumer extends Thread {
    private String name;    // スレッドの名前
    private Queue queue;    // キューのインスタンス

    // コンストラクタ　スレッド名とキューを保存
    Consumer(String name, Queue queue) {
        this.name = name;
        this.queue = queue;
    }

    // スレッド処理
    // Consumerは、キューがいっぱいになるまで待機し、
    // キューが一杯になれば、キューが空になるまで一度に読み取る
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " : " + queue.read());
        }
    }
}