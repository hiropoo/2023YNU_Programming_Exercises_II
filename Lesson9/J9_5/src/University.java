public class University {
    String name;    // 箱根駅伝の本戦出場校の名前
    int n; // 優勝回数

    // コンストラクタで名前と優勝回数を保存
    public University(String name, int n) {
        this.name = name;
        this.n = n;
    }

    // toString()のオーバーライド
    // 戻り値は、"名前 優勝回数"
    @Override
    public String toString() {
        return (name + " " + n);
    }

}
