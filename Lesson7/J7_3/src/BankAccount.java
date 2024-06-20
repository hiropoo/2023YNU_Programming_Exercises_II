public class BankAccount {
    private int balance = 0;    // 残高を表す

    // 引数の額を預け入れるメインスタンスソッド
    public void deposit(int deposits) throws IllegalArgumentException {
        // 引数が0以下の場合は、IllegalArgumentException を発生させる
        if(deposits <= 0) {
            throw new IllegalArgumentException("預入金額が0または負です");
        } 
        else {
            //　預けられた額残高を増やす 
            this.balance += deposits;
        }
    }

    // 引数の額を引き出すインスタンスメソッド
    public void withdraw(int withdraws) throws IllegalArgumentException {
        // 引数が0以下の場合や、引き出しで残高が負になる場合は、
        // IllegalArgumentException を発生させる
        if(withdraws <= 0) {
            throw new IllegalArgumentException("引出金額が0または負です");
        } 
        else if(this.balance < withdraws) {
            throw new IllegalArgumentException("残高不足の為引出出来ません");
        }
        else {
            //　引き出された額残高を減らす 
            this.balance -= withdraws;
        }
    }

    // 残高を確認するインスタンスメソッド
    public int getbalance() {
        return this.balance;
    }
}
