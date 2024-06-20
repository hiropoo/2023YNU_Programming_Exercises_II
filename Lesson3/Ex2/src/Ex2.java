public class Ex2 {
    public static void main(String[] args) throws Exception {
        
        // エラー処理
        if(args.length < 3) {
            System.err.println("正しいコマンドライン引数を設定してください");
            System.exit(-1);
        }

        // 第１引数と第３引数を保存
        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[2]);

        // 第２引数の一文字目を演算子として保存
        // public char charAt(int index)
        // 指定されたインデックスのchar値を返す
        char operator = args[1].charAt(0);

        double result = 0;  // 計算結果を保存

        // 入力された演算子による四則演算を実行
        switch(operator) {
            // 足し算
            case '+':  
                result = num1 + num2;
                break;

            // 引き算
            case '-':  
                result = num1 - num2;
                break;

            // 掛け算
            case 'x':  
                result = num1 * num2;
                break;
            
            // 割り算
            case '/':  
                result = num1 / num2;
                break;
            
            // その他の場合のエラー処理
            default: 
                System.err.println("正しく演算子が入力されませんでした");
                System.exit(-1);
        }


        // 計算過程と結果を出力
        // public static String format(String format, Object... args)
        // formatメソッドでdouble型の変数の桁数を調整
        System.out.println(args[0] + " " + (operator=='/' ? '÷':args[1]) + " " + args[2] + " = " +      String.format("%5f", result));

    }
}
