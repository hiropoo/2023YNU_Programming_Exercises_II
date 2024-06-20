public class Counter {
    // カウントを保存する変数
    private int count = 0;

    // カウントを増やすメソッド
    public synchronized void countUP() {
        count++;
    }

    // count のゲッター
    public int getCount() {
        return count;
    }
 
}