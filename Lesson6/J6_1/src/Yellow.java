public class Yellow implements Light {
    // 指示を示すメソッドオーバーライド
    @Override
    public void print() {
        System.out.println("Yellow is " + INSTRUCTION[2]);
    }
}
