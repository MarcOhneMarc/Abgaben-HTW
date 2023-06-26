import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
    private Queue <Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int produce() throws InterruptedException {
        synchronized (queue) {
            Random ran = new Random();
            int numb = ran.nextInt(1000);
            System.out.println("Random Int: " + numb);
            return numb;
        }
    }
}
