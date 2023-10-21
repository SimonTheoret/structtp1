import java.util.Iterator;
import java.lang.Math;

public class Grid2D implements Grid {

    private int height, width;
    private String[][] content;

    public int getHeight() {
        return this.height;
    };

    public int setHeight(int height) {
        this.height = height;
        return height;
    };

    public int getWidth() {
        return this.width;
    };

    public int setWidth(int width) {
        this.width = width;
        return width;
    };

    public String setPositionValue(int x, int y, String v) {
        content[x][y] = v;
        return v;
    }
    public String getValue(int x, int y){
        return content[x][y];
        }

    public String[][] getNeighbors(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x and y must be greater than 0. x: " + x + " y: " + y);
        }
        if (x >= width || y >= height) {
            throw new IllegalArgumentException("x and y must be smaller than width and height. x: " + x + " y: " + y);
        }
        String[][] neighbors = new String[3][3];
        for (int i = -1; i < 2; i++) { // x
            for (int j = -1; j < 2; j++) { // y
                if (-1 < x + i && x + i < this.width && -1 < y + j && y + j < this.height) {
                    neighbors[i + 1][j + 1] = this.content[x + i][y + j];
                } else {
                    neighbors[i + 1][j + 1] = null;
                }
            }
        }
        return neighbors;
    }

    public Grid2D(int width, int height, String[] gridContent) {
        this.width = width;
        this.height = height;
        this.content = new String[width][height];
        int j = height - 1;
        for (String line : gridContent) {
            int i = 0;
            for (String letter : line.split(" ")) {
                this.content[i][j] = letter;
                i = i + 1;
            }
            j = j - 1;
        }

    }

    public Iterator<int[]> iterator() {
        return new Grid2DIterator(this);
    }

    private class Grid2DIterator implements Iterator<int[]> {

        private int counter, width, height;

        public Grid2DIterator(Grid2D g) {
            this.counter = 0;
            this.width = g.width;
            this.height = g.height;
        }

        public boolean hasNext() {
            return (this.counter < width * height );
        }

        public int[] next() {
            int x = counter % this.width;
            int y = Math.floorDiv(counter, this.width);
            this.counter = this.counter +1;
            int[] pos = {x,y};
            return pos;
        }
    }
}
