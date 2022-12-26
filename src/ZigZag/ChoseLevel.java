package ZigZag;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class ChoseLevel extends JFrame implements ActionListener {
    static ZigZag zigzag;

    public ChoseLevel() {

        setLayout(null);
        JLabel label1 = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/background.png"))));
        label1.setBounds(0, 0, 700, 700);

        setTitle("Start Game");
        //getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        //setFocusable(true);

        JButton button1 = new JButton("Easy");
        button1.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        button1.setSize(200, 50);
        button1.setLocation(250, 200);
        button1.addActionListener(this::Play);
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(button1);


        JButton button2 = new JButton("Medium");
        button2.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        button2.setSize(200, 50);
        button2.setLocation(250, 300);
        button2.addActionListener(this::PlayMedium);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //add(Box.createRigidArea(new Dimension(0, 0)));

        JButton button3 = new JButton("Hard");
        button3.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        button3.setSize(200, 50);
        button3.setLocation(250, 400);
        button3.addActionListener(this::PlayHard);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //add(Box.createRigidArea(new Dimension(0, -10)));


        //add(button1);
        add(button2);
        add(button3);
        add(label1);


    }


    private void Play(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        zigzag = new ZigZag(5);

    }

    private void PlayMedium(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        zigzag = new ZigZag(7);
    }

    private void PlayHard(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        zigzag = new ZigZag(10);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ChoseLevel().setVisible(true);
    }
}
