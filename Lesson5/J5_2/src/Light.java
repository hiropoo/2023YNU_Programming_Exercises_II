abstract class Light {
    // 指示の文字列を保持する変数
    protected String str;

    // インスタンス変数strを初期化するコンストラクタ
    Light(String str) {
        this.str = str;
    }

    // 指示を出力する抽象メソッド
    abstract void print();
}
