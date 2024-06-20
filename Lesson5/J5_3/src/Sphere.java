public class Sphere extends Circle {
    // 半径 radius を初期化するコンストラクタ
    Sphere(double radius) {
        super(radius);
    }

    // 球の体積を計算し、その値を戻り値とするインスタンスメソッド
    public double getVol() {
        return 4 / 3.0 * Math.PI * Math.pow(radius, 3);
    }
}
