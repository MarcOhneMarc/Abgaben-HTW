import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int consume() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("Queue is empty, waiting for producer...");
                queue.wait();
            }

            String StrValue = String.valueOf(queue.poll());
            System.out.println("Consuming: " + StrValue);
            int queersum = 0;
            for(int i = 0; i < StrValue.length(); i++) {
                int j = Character.digit(StrValue.charAt(i), 10);
                queersum += j;
            }
            System.out.println(queersum);
            queue.notifyAll();
        }
    }
}
