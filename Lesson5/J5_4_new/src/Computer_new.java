import java.util.ArrayList;
import java.util.Random;

public class Computer_new extends Board_new {
    // 記号用の変数を保存するインスタンス変数
    private char symbol;

    // [追加] 乱数のベースを保存するリスト
    static private ArrayList<Integer> list = new ArrayList<>();
    // [追加] listの初期化
    static {
        for(int i = 0; i < 9; i++) {
            list.add(i);
        }
    }

    // 記号用の変数を初期化するコンストラクタ
    public Computer_new(char symbol) {
        this.symbol = symbol;
    } 

    @Override
    // 3x3のマス（board[][]）の空いているマスのうちランダムな箇所に記号を置くメソッド
    // どこにも置く場所がなかった場合は false を戻り値として返す  
    public boolean put() {
        // ボードに記号を置くことができるかどうかを判断
        if(check()) {
            // [変更] 置くことができる場合はランダムな場所に記号を設置
            // [変更] ランダムな数値は、getRandNum()メソッドを通じて、重複なく取得
            int randNum = getRandNum();
            int rowIndex = randNum / 3;
            int colIndex = randNum % 3;
            board[rowIndex][colIndex] = symbol;

            return true;    // 置くことができたのでtrueを返す
        } else {
            return false;   // 置く場所がないのに呼ばれたのでfalseを返す
        }

    }


    // [追加] 重複なく乱数を返すメソッド
    private int getRandNum() {
        Random rd = new Random();
        int index = 0;
        
        // 0 ~ (listのサイズ - 1) で乱数を発生
        if(list.size() > 1) {
            index = rd.nextInt(list.size() - 1);
        }
        
        // 発生した乱数をindexとしてlistの中身を取得
        int retNum = list.get(index);

        // 取得した位置のlistの要素を削除
        list.remove(index);

        return retNum;
    }


    // 3x3のボード上にまだ置ける場所が残っているか確認するメソッド
    // 置くことができればtrue, これ以上置く場所がなければfalseを返す
    private boolean check() {
        boolean flag = false;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                // 置くことができる場所があった時点で戻り値trueを確定させる
                if(board[i][j] == '〇') {
                    flag = true;
                    return flag;
                }
            }
        }

        return flag;
    }
}
