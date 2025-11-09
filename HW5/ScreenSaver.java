import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ScreenSaver{
    private static JFrame frame;
    
    public static void main(String[] args) {
        // creating the JFrame
        frame = new JFrame( "ScreenSaver" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        frame.setSize(800,600);
        SSPanel ss = new SSPanel();
        frame.add(ss);
        frame.setVisible(true);
    }

    static class SSPanel extends JPanel implements ActionListener{
        protected Timer timer;
        
        public SSPanel(){
            timer = new Timer(1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent e){
            repaint();
        }
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Random r = new Random();
            int h = getHeight();
            int w = getWidth();
            
            /// 50 ovals
            /// random color, brush thickness, location, size
            for(int i = 0; i < 50; i ++){
                /// picks x/y and width/height from random, it insure the circle stays on screen the width/height can only be between x/y and w/h
                /// uses Math.max to prevent a 0 or negative bound
                int x = r.nextInt(Math.max(1, w));
                int y = r.nextInt(Math.max(1, h));
                int width = Math.max(1,r.nextInt(w-x));
                int height = Math.max(1,r.nextInt(h-y));
                Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
                BasicStroke thickness = new BasicStroke(r.nextInt(10)+1);
                g2d.setColor(c);
                g2d.setStroke(thickness);
                g2d.drawOval(x, y, width, height);
                
            }
        }
    }
}