import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<Integer> buffer;
    private int maxSize;

    public Buffer(int maxSize)
    {
        buffer = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized int take()
    {
        while (buffer.isEmpty())
        {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        notifyAll();
        return buffer.remove();
    }

    public synchronized void put(int num) {
        while (buffer.size() >= maxSize)
        {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        buffer.add(num);
        notifyAll();
    }
}