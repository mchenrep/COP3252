import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;
import javax.swing.*;

public class Triangles{
    private static JFrame frame;

    public static void main(String[] args) {
        // creating the JFrame
        frame = new JFrame( "Triangles" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        frame.setSize(500,500);
        // adding the triangles to JFrame
        frame.add(new TPanel());
        // displaying the JPanel
        frame.setVisible( true );
        
    }

    static class TPanel extends JPanel{
        
        public void paintComponent(Graphics g){
            // override JPanel paintComponent method
            super.paintComponent(g);
            // upgrade (and upcast) to Graphics 2D
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();
            
            /// loop 5 times (to draw 5 triangles)
            /// choose 3 random x/y points within (w,h) to connect with GeneralPath
            /// fill with random color
            
            Random random = new Random();
            
            for(int i = 0; i < 5; i++){
                GeneralPath t = new GeneralPath();

                t.moveTo(random.nextInt(w), random.nextInt(h));
                t.lineTo(random.nextInt(w), random.nextInt(h));
                t.lineTo(random.nextInt(w), random.nextInt(h));

                t.closePath();
                Color c = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                g2d.setColor(c);
                g2d.fill(t);
            }            
        }
    }
}
