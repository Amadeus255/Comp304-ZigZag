package ZigZag;

public class Tile {
    double x, y;
    int angle, direction;
    boolean invisible = false;


    public Tile(double x, double y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;

        if (direction == 0) {
            angle = -45;
        } else {
            angle = 45;
        }
    }

    public void invalidate() {
        invisible = y < -500;
    }

}
