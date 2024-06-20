public class MonteCarlo {
    public static void main(String[] args) {
        
        // in: 扇形(第一象限における円)の内部に生成された点の数を記憶
        int in = 0;

        // (x, y) の組を1000組発生させて、円の1/4の内部に生成された座標の組の個数を計算
        for(int i = 1; i <= 1000; i++) {
            // (x, y)の組を格納する変数を定義
            double x; 
            double y;

            // x, y ともに、[0, 1]の範囲でランダムな座標を割り当て -> 第1象限のみを考える
            x = Math.random() / Math.nextDown(1.0);
            y = Math.random() / Math.nextDown(1.0);

            // 原点からの距離を計算
            double dis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

            // 円の内部に生成されたかどうかを判断しカウント
            if(dis <= 1) {
                in++;
            }
        }

        // π/4 = (扇形の内部に存在する点の個数) / (前端の点の個数) からπを計算
        double myPI = (double) 4 * in / 1000;

        // 静的変数πと求めたπとの誤差の割合を計算
        double errorRate = Math.abs(Math.PI - myPI) / 100;

        // 結果を出力
        System.out.println("モンテカルロ法で求めたπ: " + myPI);
        System.out.printf("静的変数πと求めたπの誤差: %.5f%%", errorRate);

    }
}
