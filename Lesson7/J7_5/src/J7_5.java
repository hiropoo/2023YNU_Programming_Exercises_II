public class J7_5 {
    public static void main(String[] args) throws Exception {
        String className = null;
        
        try {
            className = args[0];
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("コマンドライン引数を入力してください");
            e.printStackTrace();

        }

        // className が参照を持つ　= コマンドライン引数による例外処理がなかった場合
        if(className != null) {
            int numOfParents = 0;
            try {
                // className クラスのスーパークラスの数を数えて変数に保存
                numOfParents = countParents(className); 

                // スーパークラスの数を表示
                System.out.println(className);
                System.out.println("> スーパークラスの数: " + numOfParents + "個");

            } catch (ClassNotFoundException e) {    // countParents()メソッドのエラー処理
                System.out.println("クラス: " + className + " が見つかりませんでした");
                e.printStackTrace();
            }   

        }
        
    }


    // 引数に受け取った完全修飾クラス名のClassオブジェクトについて
    // そのスーパークラスの数を数えるメソッド
    private static int countParents(String className) throws ClassNotFoundException {
        Class<?> cls = Class.forName(className);

        int numOfParents = 0;   // スーパークラスの数を保存
        // スーパークラスを取得して更新する
        // getSuperclass() は取得できるスーパークラスがない場合に null
        // を返すことを利用して、スーパークラスの数を数える。 
        while((cls = cls.getSuperclass()) != null) {
            numOfParents++;
        }
        
        return numOfParents;
    }

}
