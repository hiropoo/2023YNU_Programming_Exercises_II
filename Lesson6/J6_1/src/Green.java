public class Green implements Light {
    // 指示を示すメソッドオーバーライド
    @Override
    public void print() {
        System.out.println("Green is " + INSTRUCTION[0]);
    }
}
