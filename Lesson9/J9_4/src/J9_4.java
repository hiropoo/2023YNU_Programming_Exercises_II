import java.util.Scanner;

public class J9_4 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Prefecture prefecture = new Prefecture();
        String inputKey = ""; // Scannerで読み取ったkeyを保存
        String returnStr = "";  // HashMap.get(inputKey) の戻り値を保存

        // HashMap に格納したすべてのキーと値のペアを表示
        System.out.println(prefecture);

        // キーの入力を受け付け
        System.out.println("キーを入力してください (end: 終了)");

        // end が入力されるまで繰り返し
        while (!(inputKey = sc.next()).equals("end")) {
            // get()で入力されたキーを探す。見つからなければnullが返される
            if ((returnStr = prefecture.map.get(inputKey)) == null) {
                System.out.println("見つかりません\n");
            } else {
                System.out.println(returnStr + "\n");
            }

            // キーの入力を受け付け
            System.out.println("キーを入力してください (end: 終了)");
        }

        sc.close();
    }
}
