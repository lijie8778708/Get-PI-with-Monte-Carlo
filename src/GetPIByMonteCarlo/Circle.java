package GetPIByMonteCarlo;

/**
 * @author jieli
 * Create a circle class with basic attribute
 */
public class Circle {

    private int x;
    private int y;
    private int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean contains(MyPoint p){
        return Math.pow(p.getX()-x, 2) + Math.pow(p.getY()-y, 2) <= r*r;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
