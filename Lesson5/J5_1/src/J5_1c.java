public class J5_1c {
    public static void main(String[] args) throws Exception {
        // アップキャスト
        ClassA a = new ClassC();
        a.print();

        // 一度アップキャストした a を明示的にダウンキャスト
        ClassC c = (ClassC)a;
        c.print();
    }
}
