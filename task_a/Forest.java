public class Forest {
    private final Integer[][] forest;
    private volatile boolean isBearFound;

    public Forest(int rows, int columns) {
        isBearFound = false;
        forest = new Integer[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                forest[i][j] = 0;
            }
        }
    }

    public int getRowsN() {
        return forest.length;
    }

    public int getColumnsN() {
        return forest[0].length;
    }

    public void setBear(int row, int column) {
        forest[row][column] = 1;
    }

    public boolean checkBear(int row, int column) {
        if(forest[row][column] == 1) {
            isBearFound = true;
            return true;
        }
        return false;
    }

    public boolean isBearFound() {
        return isBearFound;
    }
}
