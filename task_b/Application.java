import java.util.concurrent.LinkedBlockingQueue;

public class Application {
    private final Integer itemsAmount;

    public Application(Integer itemsAmount) {
        this.itemsAmount = itemsAmount;
    }

    public void start() {
        LinkedBlockingQueue<Item> firstQueue = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Item> secondQueue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(firstQueue, itemsAmount, 2000);
        ConsumerProducer consumerProducer = new ConsumerProducer(firstQueue, secondQueue, 3000);
        Consumer consumer = new Consumer(secondQueue, 1500);

        new Thread(producer).start();
        new Thread(consumerProducer).start();
        new Thread(consumer).start();
    }

    public static void main(String[] args) {
        new Application(5).start();
    }
}
