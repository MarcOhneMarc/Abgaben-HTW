
import java.util.Collection;
import java.util.Random;

public class Producer implements Runnable {
    private Collection <Integer> queue;

    public Producer(Collection<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int produce() throws InterruptedException {
        Random random = new Random();
        return random.nextInt(1000);
    }
}
