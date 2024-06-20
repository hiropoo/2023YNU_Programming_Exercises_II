package p;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class J7_Test {
    public static void main(String[] args) throws Exception {
        try {
            // Classオブジェクトを取得
            Class<?> cls = Class.forName("p.Hello");

            // Classオブジェクトに対応するクラスのインスタンスを生成する
            Constructor constructor = cls.getConstructor(String.class);  // Helloオブジェクトを生成するコンストラクタを保存するコンストラクタオブジェクトを生成
            Hello obj = (Hello)constructor.newInstance("hoge");    // コンストラクタに引数 "everyone" を与えてインスタンスを生成
            obj.Greeting();     // インスタンスメソッドを利用


            // クラスオブジェクトからフィールドを取得
            Field field = cls.getDeclaredField("name");   // nameフィールドを保存するフィールドオブジェクトを生成
            field.setAccessible(true);      // フィールドにアクセス可能にする
            field.set(obj, "fuga");


            // クラスオブジェクトからメソッドを取得
            Method method = cls.getMethod("Greeting");    // Greeting()を保存するメソッドオブジェクトを生成
            method.invoke(obj);     // invoke()メソッドを利用して、メソッド(Greeting())を実行

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        

    }
}


