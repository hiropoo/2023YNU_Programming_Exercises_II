public class J5_2 {
    public static void main(String[] args) throws Exception {
        // Light型のインスタンス保存する配列 lights を生成
        Light[] lights = new Light[3];
        lights[0] = new Green("Walk");
        lights[1] = new Red("Stop");
        lights[2] = new Yellow("Caution");

        // 拡張for文を使って、lights[]の各インスタンスのprint()メソッドを呼び出し
        for(Light light: lights) {
            light.print();
        }
    }
}
