import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducer implements Runnable{
    private final LinkedBlockingQueue<Item> source;
    private final LinkedBlockingQueue<Item> target;
    private long timeToSleep;

    public ConsumerProducer(LinkedBlockingQueue<Item> source, LinkedBlockingQueue<Item> target, long timeToSleep) {
        this.source = source;
        this.target = target;
        this.timeToSleep = timeToSleep;
    }

    @Override
    public void run() {
        Item item;
        do {
            try {
                item = source.take();
                Thread.sleep(timeToSleep);
                target.put(item);
                System.out.println("> " + item.getName() + " is transferred");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!item.isLast());
    }
}
