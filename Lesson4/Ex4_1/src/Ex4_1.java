public class Ex4_1 {
    public static void main(String[] args) throws Exception {
        // AddIntクラスのインスタンスを作成
        AddInt obj = new AddInt(2);

        // メソッドの動作の確認
        System.out.println("AddInt obj = new AddInt(2)");
        System.out.println("obj.getN(): " + obj.getN());
        System.out.println("obj.add(10): " + obj.add(10));
        System.out.println("obj.add(10, 20): " + obj.add(10, 20));
    }
}


class AddInt {
    // インスタンス変数
    private int n;

    // インスタンス変数ｎを初期化するコンストラクタ
    AddInt(int n) {
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

    // add()をオーバーロード (仮引数２個を足した結果を戻り値とするメソッド)
    public int add(int num1, int num2) {
        return this.n + num1 + num2;
    }
}

