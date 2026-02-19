import java.util.Random;

public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int num = buffer.take();
        Random random = new Random();
        while (num != -1)
        {
            System.out.println("Took num: " + num);
            num = buffer.take();

            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {}
        }
    }
}