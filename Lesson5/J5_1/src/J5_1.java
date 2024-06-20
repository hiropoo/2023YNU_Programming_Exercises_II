public class J5_1 {
    public static void main(String[] args) throws Exception {
        ClassA a = new ClassC();
        a.print();

        a = new ClassB();
        a.print();
        
        a = new ClassA();
        a.print();
    }
}
