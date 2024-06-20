public class J7_4 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = null;
        
        // コマンドライン引数で受け取った完全修飾クラス名に一致する
        // Classオブジェクトを保存
        try {
            cls = Class.forName(args[0]);

        } catch (ArrayIndexOutOfBoundsException e) {    // 引数がなかった場合
            System.out.println("コマンドライン引数を入力してください");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("クラス: " + args[0] + " が見つかりませんでした");
            e.printStackTrace();
            
        }

        // cls が参照を持つ = 例外処理がなかった場合
        if(cls != null) {
            System.out.println(cls.getName() + " のスーパークラス: ");

            int numOfParents = 0;   // スーパークラスの数を保存

            // スーパークラスを取得して更新する
            // getSuperclass() は取得できるスーパークラスがない場合に null
            // を返すことを利用して、スーパークラスの数を数える。 
            while((cls = cls.getSuperclass()) != null) {
                System.out.println("  " + cls.getName());
                numOfParents++;
            }

            System.out.println("\nスーパークラスの数: " + numOfParents + "個");
        }
        
    }
}
