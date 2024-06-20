public class J8_4 {
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        new Producer(queue).start();
        new Consumer("ConsumerA", queue).start();
        new Consumer("ConsumerB", queue).start();
        new Consumer("ConsumerC", queue).start();
    }
}
