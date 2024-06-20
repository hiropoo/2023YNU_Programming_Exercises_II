public class Green extends Light {
    // インスタンス変数
    // String str;  (Light class)

    public Green(String str) {
        // スーパークラス Light のコンストラクタを使用して文字列strを初期化
        super(str);        
    }

    @Override
    // 指示を出力するprint()メソッドを実装
    void print() {
        System.out.println("Green is " + str);
    }        
}
