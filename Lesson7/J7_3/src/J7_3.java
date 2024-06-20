import java.util.InputMismatchException;
import java.util.Scanner;

public class J7_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice = '\0';
        BankAccount person = new BankAccount();
        
        // メニューの表示と選択の読み取り
        System.out.println("預入: d, 引出: w, 残高照会: g, 終了: e");
        choice = sc.next().charAt(0);

        // 終了: e が選ばれなければ処理を繰り返す
        while(choice != 'e') {
            try {
                switch (choice) {
                    case 'd':   // 預入
                        System.out.println("預入金額を入力");
                        int deposits = sc.nextInt();
                        person.deposit(deposits);
                        break;

                    case 'w':   // 引出
                        System.out.println("引出金額を入力");
                        int withdraws = sc.nextInt();
                        person.withdraw(withdraws);
                        break;

                    case 'g':   // 残高照会
                        System.out.println("残高: " + person.getbalance());
                        break;

                    default:
                        System.out.println("d, w, g, e の中から入力してください");
                        break;
                }

            } catch (IllegalArgumentException e) {  // BankAccountクラスのメソッドが投げるエラー
                // エラー内容を表示
                System.out.println(e.getMessage());

            } catch (InputMismatchException e) {    // ScannerのnextInt()が投げるエラー
                System.out.println("int型を入力してください");
                sc.nextLine();

            } finally {
                // メニューの表示と読み取り
                System.out.println("\n預入: d, 引出: w, 残高照会: g, 終了: e");
                choice = sc.next().charAt(0);
            }
  
        }
    
        sc.close();

    }
}
