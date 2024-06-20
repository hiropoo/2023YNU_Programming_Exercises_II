public class J8_1 {
    public static void main(String[] args) throws Exception {
        AddThread add = new AddThread();
        MulThread mul = new MulThread();

        // スレッドを実行
        add.start();
        mul.start();
    }
}


// 1 ~ 10 までの整数を全て足し合わせるスレッド 
class AddThread extends Thread {
    @Override
    public void run(){
        // 計算結果を保存する変数
        int add = 0;

        for(int i = 1; i <= 10; i++) {
            add += i;

            // sleep() メソッドを実行
            // try {
            //     Thread.sleep(1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

            // スレッドの名前と足し算結果を表示
            System.out.println("add" + " = " + add);
        }
    }

}


// 1 ~ 10 までの整数を全て掛け合わせるスレッド 
class MulThread extends Thread {
    @Override
    public void run(){
        // 計算結果を保存する変数
        int mul = 1;

        for(int i = 1; i <= 10; i++) {
            mul *= i;

            // sleep() メソッドを実行
            // try {
            //     Thread.sleep(1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

            // スレッドの名前と掛け算の結果を表示
            System.out.println("mul" + " = " + mul);
        }
    }

}

