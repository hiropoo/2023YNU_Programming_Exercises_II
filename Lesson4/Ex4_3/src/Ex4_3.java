public class Ex4_3 {
    public static void main(String[] args) throws Exception {
        // 異なる二つのコンストラクタを用いてインスタンスを生成
        Rectangular rec1 = new Rectangular(3.5, 4.5);
        Rectangular rec2 = new Rectangular(3.5);
        
        // インスタンス変数の値と面積を出力
        System.out.println("rec1: ");
        rec1.printHW();
        System.out.println("面積: " + rec1.getArea() + "\n");
        
        System.out.println("rec2: ");
        rec2.printHW();
        System.out.println("面積: " + rec2.getArea());
    }
}


class Rectangular {
    // インスタンス変数
    double height;      // 縦の長さ
    double width;       // 横の長さ

    // コンストラクタ
    Rectangular(double height, double width) {
        this.height = height;
        this.width = width;
    }

    // コンストラクタをオーバーロード
    // 横の長さは、default値10
    Rectangular(double height) {
        this(height, 10);
    }

    // 縦、横の長さを出力するメソッド
    public void printHW() {
        System.out.println("縦の長さ: " + height);
        System.out.println("横の長さ: " + width);
    }

    // 面積を計算し戻り値とするメソッド
    public double getArea() {
        return height * width;
    }


}
