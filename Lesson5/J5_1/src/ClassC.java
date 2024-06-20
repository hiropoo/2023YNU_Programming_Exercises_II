public class ClassC extends ClassB {
    // スーパークラスのprint()メソッドをオーバーロード
    public void print() {
        // スーパークラス (= ClassB) のprint()メソッドを呼び出し
        super.print();

        System.out.println("ClassC");
    }
}
