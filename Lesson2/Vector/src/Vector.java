public class Vector {
    public static void main(String[] args) {
        // 3次元ベクトルを格納するための配列を宣言
        double[] vec = new double[3];
        vec[0] = 3; vec[1] = 4; vec[2] = 5;

        // ベクトルの大きさを計算
        double size = Math.sqrt(Math.pow(vec[0], 2) + Math.pow(vec[1], 2) + Math.pow(vec[2], 2));

        System.out.printf("ベクトルの大きさは%.3fです\n", size);
    }

}

