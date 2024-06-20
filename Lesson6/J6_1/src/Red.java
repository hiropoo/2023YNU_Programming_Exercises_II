public class Red implements Light {
    // 指示を示すメソッドオーバーライド
    @Override
    public void print() {
        System.out.println("Red is " + INSTRUCTION[1]);
    }
}
