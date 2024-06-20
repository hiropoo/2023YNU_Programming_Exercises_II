public class Ex1 {
    public static void main(String[] args) {

        // エラー表示
        if(args.length < 1) {
            System.out.println("コマンドラインに入力してください");
            System.exit(-1);
        }
        
        // コマンドライン引数として与えられた数字を出力
        System.out.println("コマンドラインから入力された数字: " + args[0]);

        // コマンドライン引数で与えられた文字列をint型の値に変換
        int cmdArgInt = Integer.parseInt(args[0]);

        // 10進数、２進数、16進数の値をそれぞれ出力
        // public static String toString(int i, int radix)
        // １番目の引数の値(10進数)を、(２番目の引数)進数にし、その文字列を返す
        System.out.println("10進数: " + args[0]);
        System.out.println("2進数表記: " + Integer.toString(cmdArgInt, 2));
        System.out.println("16進数表記: " + Integer.toString(cmdArgInt, 16));

    }
}