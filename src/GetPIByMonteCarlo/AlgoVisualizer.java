package GetPIByMonteCarlo;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author jieli
 * Similate the monte carlo to estimate for PI value
 * Circle area = PI * R * R and square's area = 2R * 2R
 * PI = 4 * circle area/square area
 */

public class AlgoVisualizer {

    private int insideCircle = 0;
    private static final int DELAY = 5;
    private Circle circle;
    private LinkedList<MyPoint> list;
    private AlgoFrame frame;
    private int N;

    public AlgoVisualizer(int width, int height, String title, int N) {

        // the window has to be a square
        if(width != height){
            throw new IllegalArgumentException("width and height has to be same");
        }

        // create a circle and the circle's edge will touch square's edge
        circle = new Circle(width/2, height/2, width/2);
        list = new LinkedList<>();
        this.N = N;

        EventQueue.invokeLater(() -> {

            frame = new AlgoFrame(title, width, height);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    private void run() {

        for(int i = 0; i < N; i++) {

            if(i%10 == 0) {
                frame.render(circle, list);
                AlgoVisHelper.pause(AlgoVisualizer.DELAY);

                double circleArea = insideCircle;
                double squareArea = list.size();
                double piEstimate = 4 * circleArea / squareArea;

                System.out.println("Estimate PI is : " + piEstimate);
            }
            // get a random coordinate to put the point
            int x = (int)(Math.random()*frame.getWidth());
            int y = (int)(Math.random()*frame.getHeight());

            MyPoint p = new MyPoint(x, y);
            list.add(p);
            if(circle.contains(p)){
                // count how many points are inside of circle
                insideCircle++;
            }
        }
    }
}