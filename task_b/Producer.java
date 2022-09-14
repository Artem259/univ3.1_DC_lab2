import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{
    private final LinkedBlockingQueue<Item> target;
    private final Integer itemsToProduce;
    private Integer counter = 1;
    private final long timeToSleep;

    public Producer(LinkedBlockingQueue<Item> target, Integer itemsToProduce, long timeToSleep) {
        this.target = target;
        this.itemsToProduce = itemsToProduce;
        this.timeToSleep = timeToSleep;
    }

    @Override
    public void run() {
        while (counter <= itemsToProduce) {
            Item item = new Item("Item"+counter, counter.equals(itemsToProduce));
            try {
                Thread.sleep(timeToSleep);
                target.put(item);
                System.out.println("+ " + item.getName() + " is produced");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
    }
}
