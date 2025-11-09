import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Snowman{
    private static JFrame frame;
    
    public static void main(String[] args) {
        // creating the JFrame
        frame = new JFrame( "Snowman" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        frame.setSize(600,400);
        // adding the Snowman to JFrame
        frame.add(new SPanel());
        // displaying the JPanel
        frame.setVisible( true );
    }

    static class SPanel extends JPanel{
        public void paintComponent(Graphics g){
            /// bottom = 1/2 snowman's height
            /// middle = 2/3rd remaining height
            /// top = 1/3rd remaining height
            /// height = 3/4th panel height
            /// has eyes (where the eyes would be on a human) and arms (facing upwards from middle body)
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Random r = new Random();

            int h = (int)(getHeight() * .75); // height = 3/4th panel height
            int top = (getHeight() - h) / 2;
            // getting the radius (height = diameter/2) of the body circles
            int br = (h/2)/2; 
            int mr = br * 2 / 3; 
            int tr = br/3;

            Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            g2d.setColor(c);
            g2d.drawOval((getWidth()/2) - br, top + (h - br*2), br*2, br*2); // bottom circle
            c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            g2d.setColor(c);
            g2d.drawOval((getWidth()/2) - mr, top + (h - br*2 - mr*2), mr*2, mr*2); // middle circle
            c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            g2d.setColor(c);
            g2d.drawOval((getWidth()/2) - tr, top + (h - br*2 - mr*2) - tr*2, tr*2, tr*2); // top circle
            g2d.setColor(Color.BLACK);
            // the eyes
            g2d.fillOval((getWidth()/2) - (tr/4)*2, top + (h - br*2 - mr*2) - tr*2 + tr/2, tr/4, tr/4);
            g2d.fillOval((getWidth()/2) + tr/4, top + (h - br*2 - mr*2) - tr*2 + tr/2, tr/4, tr/4);

            // the arms
            int mH = top + (h - br*2 - mr) - mr/4; // middle height
            int mW = (getWidth()/2) - mr + mr/4; //middle left width
            int mRW = (getWidth()/2) + mr - mr/4; //middle right width
            g2d.drawLine(mW, mH, mW - mr, mH - mr);
            g2d.drawLine(mRW, mH, mRW + mr, mH - mr);
            
        }
    }
}