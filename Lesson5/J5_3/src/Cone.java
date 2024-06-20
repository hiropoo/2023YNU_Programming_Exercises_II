public class Cone extends Circle {
    // 高さを保持するインスタンス変数
    protected double height;

    // 半径radiusと高さheightを初期化するコンストラクタ
    Cone(double radius, double height) {
        super(radius);
        this.height = height;
    }

    // 高さheightを戻り値とするメソッド
    public double getHeight() {
        return height;
    }

    // 円錐の体積を計算し、その値を戻り値とするメソッド
    public double getVol() {
        // スーパークラスのgetArea()メソッドで円の面積 (= 底面積) を取得
        return super.getArea() * height / 3.0;
    }
    
}
