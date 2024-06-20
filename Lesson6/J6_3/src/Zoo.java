public class Zoo extends Facility {
    public Zoo(String name) {
        super(name);
    }
    
    @Override
    void print() {
        System.out.println("動物園: " + name);
    }
}
