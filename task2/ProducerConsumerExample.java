public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(100);
        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));
        producer.start();
        consumer.start();
    }
}
