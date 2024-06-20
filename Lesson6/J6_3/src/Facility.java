abstract public class Facility {
    // 施設名を保存するインスタンス変数
    protected String name;

    // nameを初期化するコンストラクタ
    public Facility(String name) {
        this.name = name;
    }

    // nameを出力する抽象メソッド
    abstract void print();
}
