import java.lang.Iterable;
public interface Grid extends Iterable<int[]> {
    /**
     * ADT Grid is an interface for many positions placed in a grid format.
     *
     * @author Simon Théorêt
     */
    int getHeight();

    int setHeight(int height);

    int getWidth();

    int setWidth(int width);

    public String getValue(int x, int y);

    String setPositionValue(int x, int y, String v);

    String[][] getNeighbors(int x, int y);

}
