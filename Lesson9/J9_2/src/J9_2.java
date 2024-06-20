import java.util.Random;

public class J9_2 {
    // 正規分布の乱数を保存する配列
    private static int[] list = new int[61];
    // 平均値
    private static final double mean = 0.0;
    // 標準偏差
    private static final double sigma = 1.0;


    public static void main(String[] args) throws Exception {
        // 正規分布に基づいた分布のリストを作成
        makeGaussianList();
        
        // 分布からグラフを作成
        drawGraph();
    }


    // 正規分布に基づいた乱数を発生させる
    // この時、±３σの範囲を61個に分割し分布を数える。±３σの範囲外は考えない
    // 乱数の整数部分で分割 (小数点は切り捨て)
    // list[0]: 0(= -３σ) 以上 1 未満, list[1]: 1 以上 2 未満, ... , list[60] = 60 (= +３σ) 以上 61 未満
    private static void makeGaussianList() {
        Random rd = new Random();

        for (int i = 0; i < 1000000; i++) {
            // 乱数を発生させて、配列list[]のindexに調整
            int index =  (int)Math.round(10 * rd.nextGaussian() * sigma + mean) + 30;

            // 発生した乱数の分布を保存
            if (index >= 0 && index <= 60) {
                list[index]++;
            }
        }
    }


    // 分布のリストからグラフを描画するメソッド
    // 要素数1000個につき * を1個出力
    private static void drawGraph() {
        int sum = 0;    // ±３σ間に生成された数(= リストの全要素数)をカウント    

        for (int i = 0; i < list.length; i++) {
            System.out.printf("%4.1f:", (double)(i-30)/10);

            // 要素数1000個につき * を1個出力
            for (int j = 1; j <= list[i] / 1000; j++) {
                System.out.print("*");
            }

            System.out.println("");

            // リスト中の±３σ間の全要素数をカウント
            if(i != 60) {
                sum += list[i];
            }     
        }
        
        // 平均値と標準偏差を出力
        System.out.println("\n平均値: " + mean);
        System.out.println("標準偏差: " + sigma);

        // ±３σ間の確率を出力
        System.out.println("±３σの確率: " + (double)sum * 100 / 1000000 + "%");
    }
}
