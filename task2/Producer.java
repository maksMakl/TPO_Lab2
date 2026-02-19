import java.util.Random;

public class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        Random random = new Random();

        for (int i = 0; i < 1000; i++)
        {
            buffer.put(i);
            System.out.println("Put num: " + i);

            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {}
        }
        buffer.put(-1);
    }
}