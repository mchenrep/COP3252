import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Guess{
    private static int n;
    private static int lastGuess;

    private static JPanel panel;
    private static JFrame frame;
    private static JTextField textField;
    private static JButton playAgain;
    private static JLabel label;
    private static JLabel label2;
    private static JLabel condition;
    private static Random random = new Random(); // declare and initialize random here because I'm not defining it

    public static void main(String[] args){
        // JFrame 
        frame = new JFrame();
        frame.setTitle("Guess the number");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(512,512);
        
        // JPanel
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // JLabels
        label = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        panel.add(label);
        label2 = new JLabel("Please enter your first guess.");
        panel.add(label2);

        // JTextField
        textField = new JTextField(20); // set to 20 so that the JButton later will be at the bottom when using FlowLayout
        TextFieldHandler handler = new TextFieldHandler();
        textField.addActionListener(handler);
        panel.add(textField);

        condition = new JLabel("");
        panel.add(condition);

        frame.add(panel);
        frame.setVisible(true);

        // Implementation
        n = random.nextInt(1,1000);
        lastGuess = -1; // -1 to indicate no previous guesses
    }

    private static class TextFieldHandler implements ActionListener 
    {
        // Implementation for TextField input
        public void actionPerformed( ActionEvent event )
        {
            String s = event.getActionCommand(); // get input
            try {
                int guess = Integer.parseInt(s); // parse input for ints
                if(guess < 1 || guess > 1000){
                    // in case of bad input (out of range)
                    condition.setText("Enter a number 1-1000 please.");
                }
                else{
                    if(guess == n){
                        condition.setText("Correct!");
                        textField.setEditable(false);
                        playAgain = new JButton("Play Again?");
                        ButtonHandler bhandler = new ButtonHandler();
                        playAgain.addActionListener(bhandler);
                        panel.add(playAgain);  
                    }else if(lastGuess != -1){
                        int diff = Math.abs(n - guess);
                        int ldiff = Math.abs(n - lastGuess);
                    
                        if(diff > ldiff){ // Current guess  
                            panel.setBackground(Color.BLUE);
                            if(guess > n){
                                condition.setText("Too High");
                            }else{
                                condition.setText("Too Low");
                            }
                        }else if (diff < ldiff){
                            panel.setBackground(Color.RED);
                            if(guess > n){
                                condition.setText("Too High");
                            }else{
                                condition.setText("Too Low");
                            }
                        }else{
                            // Current guess is equal distance away from the number then the last guess
                            panel.setBackground(Color.WHITE);
                        }  
                    }
                    lastGuess = guess;
                }
            } catch (NumberFormatException e) {
                // in case of bad input (not a number)
                condition.setText("Enter a number 1-1000 please.");
            }
            
        }
    }

    private static class ButtonHandler implements ActionListener 
    {
        // implementation for "Play Again?" button to reset game
        public void actionPerformed( ActionEvent event )
        {
            n = random.nextInt(1,1000);
            lastGuess = -1; // -1 to indicate no previous guesses
            condition.setText("");
            panel.setBackground(Color.WHITE);
            textField.setEditable(true);
            panel.remove(playAgain);
        }
    }

}