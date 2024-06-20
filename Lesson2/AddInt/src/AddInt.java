public class AddInt {
    public static void main(String[] args) {
        // 整数1～10までの和を求める
        int sum = 0;
        for(int i= 1; i <= 10; i++) {
            sum += i;
        }

        // 整数1～10までの二乗和を求める
        int sqsum = 0;
        for(int i = 1; i <= 10; i++) {
            sqsum += i*i;
        }

        // 結果を出力
        System.out.println("整数1～10までの和: " + sum);
        System.out.println("整数1～10までの二乗和: " + sqsum);

    }
}
