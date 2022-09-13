public class Bee implements Runnable{
    private final Forest forest;
    private final TaskBag<Integer> taskBag;
    private final int beeNumber;

    public Bee(Forest forest, TaskBag<Integer> taskBag, int beeNumber) {
        this.forest = forest;
        this.taskBag = taskBag;
        this.beeNumber = beeNumber;
    }

    @Override
    public void run() {
        while(true) {
            if(forest.isBearFound()) {
                break;
            }
            if(!taskBag.isRunOut()) {
                Integer row = taskBag.getNext();
                System.out.println("Bee " + beeNumber + ": takes row " + row);

                // Bear searching process...
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // Bear searching result
                for(int i=0; i<forest.getColumnsN(); i++) {
                    if(forest.checkBear(row, i)) {
                        System.out.println("Bee " + beeNumber + ": Bear is found at [" + row + "][" + i + "] !");
                    }
                }
            }
            else {
                System.out.println("Bee " + beeNumber + ": The forest is over.");
                break;
            }
        }
    }
}
