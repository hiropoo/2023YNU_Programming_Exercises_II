public class J6_1 {
    public static void main(String[] args) throws Exception {
        // 各インスタンスを発生
        // Green green = new Green();
        // Red red = new Red();
        // Yellow yellow = new Yellow();

        // // 各インスタンスのprint()メソッドを呼び出し
        // green.print();
        // red.print();
        // yellow.print();
        
        // Light型のインスタンス保存する配列 lights を生成
        Light[] lights = {
            new Green(),
            new Red(),
            new Yellow(),
        };

        // lights[]の各インスタンスのprint()メソッドを呼び出し
        for (Light light : lights) {
            light.print();
        }
    }
}
