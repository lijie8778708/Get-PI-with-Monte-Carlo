package GetPIByMonteCarlo;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * @author jieli
 * Initialize the window
 */
public class AlgoFrame extends JFrame {

    private int sceneWidth;
    private int sceneHeight;

    private Circle circle;
    private LinkedList<MyPoint> list = new LinkedList<>();

    AlgoFrame(String title, int sceneWidth, int sceneHeight){
        super(title);
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;

        MyPanel panel = new MyPanel();
        panel.setPreferredSize(new Dimension(this.sceneWidth, this.sceneHeight));
        this.setContentPane(panel);
        pack();

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void render(Circle circle, LinkedList<MyPoint> list){
        this.circle = circle;
        this.list = list;
        repaint();
    }


    private class MyPanel extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D)g;

            // make the maze looks more smooth
            RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics2D.addRenderingHints(renderingHints);

            AlgoVisHelper.setStrokeWidth(graphics2D, 5);
            AlgoVisHelper.setColor(graphics2D, Color.LIGHT_GRAY);
            AlgoVisHelper.strokeCircle(graphics2D, circle.getX(), circle.getY(), circle.getR());

            for(int i = 0; i < list.size(); i++){
                MyPoint p = list.get(i);

                if(circle.contains(p)){
                    AlgoVisHelper.setColor(graphics2D, Color.red);
                }else{
                    AlgoVisHelper.setColor(graphics2D, Color.GREEN);
                }
                AlgoVisHelper.fillCircle(graphics2D, (int)p.getX(), (int)p.getY(), 3);

            }
        }
    }
}
