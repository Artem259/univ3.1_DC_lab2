import java.util.Random;

public class Application {
    private final int rows, cols;
    private final int bees;

    public Application(int rows, int cols, int bees) {
        this.rows = rows;
        this.cols = cols;
        this.bees = bees;
    }


    public void start() {
        Forest forest = new Forest(rows, cols);

        Random rand = new Random();
        int bearRow = rand.nextInt(rows);
        int bearCol = rand.nextInt(cols);
        forest.setBear(bearRow, bearCol);
        System.out.println("\nBear position is [" + bearRow + "][" + bearCol + "]\n");

        Integer[] taskBagArray = new Integer[rows];
        for(int i=0; i<rows; i++) {
            taskBagArray[i] = i;
        }

        TaskBag<Integer> taskBag = new TaskBag<>(taskBagArray);
        for(int i=1; i<=bees; i++) {
            new Thread(new Bee(forest, taskBag, i)).start();
        }
    }

    public static void main(String[] args) {
        new Application(100,100,4).start();
    }
}
