import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        
        //　Stringクラスのオブジェクトを定義
        String str = "東京特許許可局許可局長";

        // Scannerクラスのインスタンスscを生成
        Scanner sc = new Scanner(System.in);

        // 文字列の入力を受付 => 文字列keyに保存
        System.out.print("文字列を入力してください: ");
        String key = sc.next();

        sc.close(); 

        // strの中にkeyが何個含まれるかを調べる => countに保存
        int count = countKey(str, key);

        System.out.print("\"" + str + "\" の中に");
        System.out.println("\"" + key + "\" は");
        System.out.println(count + "個ありました。");
    }


    // strの中にkeyが何個含まれるかを調べる静的メソッド
    // カウントした個数を返す
    public static int countKey(String str, String key) {

        // StringBufferクラスのインスタンスstrbにstrの中身を代入
        StringBuffer strb = new StringBuffer(str);

        // カウンター 
        int count = 0;

        // strbの中にkeyが含まれていた時の位置(index)を保存
        int index;

        // strb.indexOf(key) でstrb(= str)の中にkeyが含まれているか探索
        // 含まれていた場合は、それを最初に見つけた位置をindexに保存し、含まれていなければ-1を返す
        while((index = strb.indexOf(key)) != -1) {
            count++;

            // 今発見した文字列を取り除いた新たな文字列strbを生成
            strb.delete(0, index+1);
        }

        return count;
    }

}
