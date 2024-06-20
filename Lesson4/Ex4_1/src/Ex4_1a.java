// Ex4_1.java と同様の処理を、main()メソッドを持つクラスのみで実現

public class Ex4_1a {
    public static void main(String[] args) {
        // Ex4_1aクラスのインスタンスを作成
        Ex4_1a obj = new Ex4_1a(3);

        // メソッドの動作の確認
        System.out.println("Ex4_1a obj = new Ex4_1a(3)");
        System.out.println("obj.getN(): " + obj.getN());
        System.out.println("obj.add(10): " + obj.add(10));
        System.out.println("obj.add(10, 20): " + obj.add(10, 20));

    }

    // インスタンス変数
    private int n;

    // インスタンス変数ｎを初期化するコンストラクタ
    Ex4_1a (int n) {
        this.n = n;
    }

    // インスタンス変数ｎのゲッター
    public int getN() {
        return this.n;
    }

    // インスタンス変数ｎにnumを加算した結果を戻り値とするメソッド
    public int add(int num) {
        return this.n + num;
    }

    // add()をオーバーロード (仮引数２個を他した結果を戻り値とするメソッド)
    public int add(int num1, int num2) {
        return this.n + num1 + num2;
    }

}
