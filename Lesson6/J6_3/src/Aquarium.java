public class Aquarium extends Facility {
    public Aquarium(String name) {
        super(name);
    }
    
    @Override
    void print() {
        System.out.println("水族館: " + name);
    }
}
