public class Ex4_2 {
    public static void main(String[] args) throws Exception {
        // Strcovクラスのクラスメソッドをコマンドライン引数の数だけ呼び出し,
        // その戻り値を出力
        for(int i = 0; i < args.length; i++) {
            System.out.print(Strcov.toULCase(args[i]) + " ");
        }

        // Strcovクラスのクラス変数を出力
        System.out.println("\n" + Strcov.END);

    }
}


class Strcov {
    // 静的変数
    static String END = "Goodbye";

    // 静的メソッド
    static String toULCase(String str) {
        // 引数の文字列strの１文字目が大文字か小文字かを判断
        // 大文字ならばstrの全ての文字を大文字に変換
        if(Character.isUpperCase(str.charAt(0))) {
            str = str.toUpperCase();
        }
        // 小文字ならばstrの全ての文字を小文字に変換
        else if(Character.isLowerCase(str.charAt(0))) {
            str = str.toLowerCase();
        } 

        return str;
    }

}