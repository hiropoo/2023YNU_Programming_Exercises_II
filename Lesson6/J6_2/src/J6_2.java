import java.util.Scanner;

public class J6_2 {
    private static int goalNum; // 目標勝利数

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("あなたは何回勝つまでプレイしますか?");
        goalNum = sc.nextInt();
        System.out.println("");

        int wins = 0;
        int losses = 0;
        int draws = 0;

        // じゃんけんを行うプレイヤーとコンピュータを用意
        Human you = new Human();
        Computer com = new Computer();

 
        while (wins < goalNum) {
            // 人とコンピュータでじゃんけんを行う
            // 行った結果をjudge()で判断して、結果を保存
            int result = Judge.judge(you.play(), com.play());

            // 結果を表示
            switch (result) {
                case -1:
                    System.out.println("あなたの負けです");
                    losses++;
                    break;
            
                case 0:
                    System.out.println("あいこです");
                    draws++;
                    break;
            
                case 1:
                    System.out.println("あなたの勝ちです");
                    wins++;
                    break;
            
                default:
                    break;
            }
            
            System.out.printf("あなたの %d 勝 %d 負 %d あいこ です\n\n", wins, losses, draws);

        }

        sc.close();

    }
}
