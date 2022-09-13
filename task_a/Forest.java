public class Forest {
    boolean[][] forest;

    public Forest(int rows, int columns) {
        forest = new boolean[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                forest[i][j] = false;
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
        forest[row][column] = true;
    }

    public boolean checkBear(int row, int column) {
        return forest[row][column];
    }
}
