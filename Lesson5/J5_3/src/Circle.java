public class Circle {
    // 半径を保持するインスタンス変数。protectedによりサブクラス以外のアクセスを制限
    protected double radius;

    // 半径 radius を初期化するコンストラクタ
    Circle(double radius) {
        this.radius = radius;
    }

    // 円の面積を計算し、その値を戻り値とするインスタンスメソッド
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // 半径の値を戻り値とするインスタンスメソッド
    public double getRadius() {
        return radius;
    }

}
