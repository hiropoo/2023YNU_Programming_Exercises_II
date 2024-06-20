import java.util.Random;

public class Computer implements Jyanken {
    Random rd = new Random();

    // じゃんけんを行うメソッド
    // “0:グー” ,“1:チョキ”, “2:パー” に対応する整数を乱数を用いて発生させてその値を戻り値とする
    @Override
    public int play() {
        // 乱数を発生(0~2)
        int comChoice = rd.nextInt(3);

        // 出した手を表示
        switch (comChoice) {
            case 0:
                System.out.println("コンピュータは" + HANDSHAPE[0]);
                break;
            case 1:
                System.out.println("コンピュータは" + HANDSHAPE[1]);
                break;
            case 2:
                System.out.println("コンピュータは" + HANDSHAPE[2]);
                break;
        
            default:
                System.err.println("想定外の乱数の発生エラー");
                break;
        }
         
        return comChoice;
    }
}
