import java.io.File;
import java.util.*;

public class J9_5 {
    public static void main(String[] args) throws Exception {
        // J9_5.txt から、箱根駅伝の本戦出場校と優勝回数のデータを読み取るScanner
        Scanner stdin = new Scanner(new File("src/J9_5.txt"));
        String data = ""; // 読み取った1行のデータ
        ArrayList<University> ekidenList = new ArrayList<>();

        // データから出場校の名前と優勝回数を取得
        String name = "";
        int num = 0;
        while (stdin.hasNextLine()) {
            // データを読み取り、名前と優勝回数に分割
            data = stdin.nextLine();
            StringTokenizer st = new StringTokenizer(data);

            // 名前と優勝回数を保存
            name = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            // Universityインスタンスを生成してリストに追加
            ekidenList.add(new University(name, num));
        }
        
        // 優勝回数でソート (昇順)
        Collections.sort(ekidenList, new MyComp(1));
        printList(ekidenList); // ソート結果を出力

        System.out.println("--------------------------");

        // 優勝回数でソート (降順)
        Collections.sort(ekidenList, new MyComp(-1));
        printList(ekidenList); // ソート結果を出力
    }

    // ArrayList<University> を表示するメソッド
    private static void printList(ArrayList<University> list) {
        for (University university : list) {
            System.out.println(university);
        }
    }
}

// ソートに利用するMyCompクラス
// MyComp(m) の引数mが、0以上の時は昇順、負の時は降順でソート用のComparatorを生成
class MyComp implements Comparator<University> {
    int m;

    MyComp(int m) {
        this.m = m;
    }

    public int compare(University o1, University o2) {
        int n1 = o1.n; // String n1 = o1.name; コメントはnameでソートする場合
        int n2 = o2.n; // String n2 = o2.name;
        if (m >= 0)
            return n1 - n2; // return n1.compaerTo(n2);
        else
            return n2 - n1; // return n2.compareTo(n1);
    }
}
