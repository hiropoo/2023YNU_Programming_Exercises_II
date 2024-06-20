public class ExtoString {
    private int x, y;

    public ExtoString(int x, int y) {
        this.x = x;
        this.y = y;
    } 

    // toString()メソッドを改良
    @Override
    public String toString() {
        return "オーバーライド toString x = " + this.x + ", y = " + this.y;
    }
}
