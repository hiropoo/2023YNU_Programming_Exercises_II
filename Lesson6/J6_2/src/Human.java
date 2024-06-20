import java.util.Scanner;

public class Human implements Jyanken {
    Scanner sc = new Scanner(System.in);

    // じゃんけんを行うメソッド
    // キーボードから、“0:グー” ,“1:チョキ”, “2:パー” に対応する整数が入力できるようにし、その値を戻り値とする。
    @Override
    public int play() {

        // キーボードから数字を読み取る
        System.out.println("0:グー ,1:チョキ, 2:パー");
        int yourChoice = sc.nextInt();
        while(yourChoice < 0 || yourChoice > 2) {
            System.out.println("0 ~ 2 の整数を入力してください");
            System.out.println("0:グー ,1:チョキ, 2:パー");
            yourChoice = sc.nextInt();
        }
        
        // 出した手を表示
        switch (yourChoice) {
            case 0:
                System.out.println("あなたは" + HANDSHAPE[0]);
                break;
            case 1:
                System.out.println("あなたは" + HANDSHAPE[1]);
                break;
            case 2:
                System.out.println("あなたは" + HANDSHAPE[2]);
                break;
        }

        return yourChoice;
    }
}
