public class Queue {
    private final static int MAXSIZE = 10; // キューの最大容量
    int[] list = new int[MAXSIZE]; // 整数を格納するキュー
    int numOfdata = 0; // キューに存在するデータ数 (書き込み位置、読み取り位置に影響)
    int producedNum = 0; // Producerが生成する、０からの連続した整数を保存

    // キューに書き込むメソッド
    // データ数が０になったときに、一度に最大数まで書き込む
    // それ以外では待機する
    public synchronized void readAndWrite() {
        //　キューにデータが残っている間は待機
        while (numOfdata > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }

        // キューの中のデータ数が０の時は、最大数までデータを書き込む
        for (int i = 0; i < MAXSIZE; i++) {
            list[i] = producedNum;
            numOfdata++;    // データ数を増やす
            producedNum++;  // 次に生成する数をインクリメント
        }

        notifyAll();    // 待機中のスレッドに通知

    }


    // キューからデータを取り出して読み取るメソッド
    // キューの中のデータが空になれば、全て書き込まれるまで待機する
    public synchronized int read() {
        // キューのデータが空のときは待機
        while (numOfdata == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }

        // 最初に書き込まれたデータから読み取る
        int data = list[MAXSIZE - numOfdata];
        numOfdata--; // データ数を減らす

        notifyAll();    // 待機中のスレッドに通知
        
        return data;
    }


}
