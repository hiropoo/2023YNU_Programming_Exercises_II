public class Array {
    public static void main(String[] args) throws Exception {

        // 配列を定義
        int[] a = {2,5,3,8,9,7,6,1,4,10};
        int sum = 0;

        // 配列の全要素の合計を計算
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        System.out.println("配列の全要素の合計は" + sum + "です");
    }
}
