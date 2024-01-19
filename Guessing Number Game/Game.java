import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game {

    JFrame frame = new JFrame();
    ImageIcon backgroundIcon = new ImageIcon("background.png");
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING);
    ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);

    JLabel headingLabel=new JLabel();

    JLabel GuessLabel=new JLabel();

    JTextField numField=new JTextField();

    JButton submit= new JButton();

    JLabel message=new JLabel();

    ButtonHandler bHandler=new ButtonHandler();

    // final int secretNumber=6;

    Random randomNum=new Random();
    final int secretNumber=randomNum.nextInt(101);

    public Game() {


        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Guessing A Number Game");
        frame.setLocationRelativeTo(null);

        // Create a JLabel with the scaled background image
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 600, 600);

        // Add the JLabel to the frame's content pane
        frame.setContentPane(backgroundLabel);


        headingLabel.setBounds(30,30,600,60);
        headingLabel.setText("Number Guessing Game");
        headingLabel.setFont(new Font("Montserrat", Font.BOLD, 45));
        headingLabel.setForeground(Color.white);

        GuessLabel.setText("Guess Number between 0 and 100");
        GuessLabel.setBounds(0,100,600,30);
        GuessLabel.setForeground(Color.white);
        GuessLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        GuessLabel.setVerticalAlignment(JLabel.CENTER);
        GuessLabel.setHorizontalAlignment(JLabel.CENTER);


        numField.setBounds(225,150,150,150);
        numField.setOpaque(false);
        // numField.setBackground(Color.BLACK);
        numField.setForeground(Color.WHITE);
        numField.setHorizontalAlignment(JTextField.CENTER);
        numField.setFont(new Font("Comic Sans MS", Font.BOLD, 70));

        submit.setText("Submit");
        submit.setBounds(200,350,200,50);
        submit.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        submit.setFocusPainted(false);
        submit.setBackground(Color.WHITE);
        submit.addActionListener(bHandler);

        message.setBounds(0,450,600,40);
        // message.setBackground(Color.blue);
        message.setText("");
        message.setFont(new Font("Comic Sans MS", Font.BOLD,25));
        message.setForeground(Color.WHITE);
        message.setVerticalAlignment(JLabel.CENTER);
        message.setHorizontalAlignment(JLabel.CENTER);


        frame.add(message);
        frame.add(submit);
        frame.add(GuessLabel);
        frame.add(numField);
        frame.add(headingLabel);

        frame.setVisible(true);
    }

    public class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            
            if(e.getSource()==submit){
                System.out.println("Button Clicked");
                int userInput = Integer.parseInt(numField.getText());
                if (userInput>100 || userInput<0) {
                    message.setText("Number should between 0 & 100");
                    frame.add(message);
                }
                else if(userInput>secretNumber){
                    message.setText("Guess Lower");
                    frame.add(message);
                }
                else if(userInput<secretNumber){
                    message.setText("Guess Higher");
                    frame.add(message);
                }
                else if(userInput==secretNumber){
                    message.setText("You Guessed it Right");
                    frame.add(message);
                    submit.setEnabled(false);
                }
            }
            
        }
        
    }

    
}
