public class ClassB extends ClassA {
    // スーパークラスのprint()メソッドをオーバーロード
    public void print() {
        // スーパークラス (= ClassA) のprint()メソッドを呼び出し
        super.print();

        System.out.println("ClassB");
    }
}
