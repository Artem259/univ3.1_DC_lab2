import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{
    private final LinkedBlockingQueue<Item> source;
    private long timeToSleep;

    public Consumer(LinkedBlockingQueue<Item> source, long timeToSleep) {
        this.source = source;
        this.timeToSleep = timeToSleep;
    }

    @Override
    public void run() {
        Item item;
        do {
            try {
                item = source.take();
                Thread.sleep(timeToSleep);
                System.out.println("- " + item.getName() + " is consumed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!item.isLast());
    }
}
