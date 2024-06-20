import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class J9_3 {
    // 0 ~ 9 のランダムな整数を保存するリスト
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    // 乱数が重複しないように一度発生した乱数を保存する配列
    // -1 で初期化
    private static int[] flag = new int[10];
    static {
        Arrays.fill(flag, -1);
    }

    private static Random rd = new Random();

    public static void main(String[] args) throws Exception {
        // リストを作成
        makeList();

        // 昇順でソートして出力
        Collections.sort(list);
        printList();

        System.out.println();

        // 降順でソートして出力
        Collections.reverse(list);
        printList();

    }

    // リストを作成するメソッド
    private static void makeList() {
        int randNum = rd.nextInt(10); // 0 ~ 9 の乱数を発生

        // 0 ~ 9 の乱数をlistに追加
        for (int i = 0; i < 10; i++) {
            // 発生した乱数が重複しなくなるまで、乱数の発生を繰り返す
            while (flag[randNum] != -1) {
                randNum = rd.nextInt(10);
            }

            flag[randNum] = 0; // flagのindexと一致する乱数が発生したことを示す

            list.add(randNum); // 発生した乱数をリストに追加
        }
    }

    // リストを表示するメソッド
    private static void printList() {
        // リストの表示
        // 拡張for文
        System.out.println("拡張for文で出力: ");
        for (int i : list) {
            System.out.println(i);
        }

        // sysout で表示
        System.out.println("\nSystem.out.println(list): ");
        System.out.println(list);
    }
}
