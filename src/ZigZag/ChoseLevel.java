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
        JLabel label1 = new JLabel();
        ImageIcon icon4 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/background.png")));
        Image img4 = icon4.getImage();
        Image newimg4 = img4.getScaledInstance(700, 1000, Image.SCALE_SMOOTH);
        label1.setIcon(new ImageIcon(newimg4));
        label1.setBounds(0, 0, 700, 1000);

        setTitle("Start Game");
        //getContentPane().setBackground(Color.orange);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        //setFocusable(true);

        JButton button1 = new JButton();
        button1.setSize(200, 50);
        button1.setLocation(250, 200);
        ImageIcon icon1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Easy_Button.png")));
        Image img1 = icon1.getImage();
        Image newimg1 = img1.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.setOpaque(false);
        button1.setIcon(new ImageIcon(newimg1));
        button1.addActionListener(this::Play);
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(button1);


        JButton button2 = new JButton();
        button2.setSize(200, 50);
        button2.setLocation(250, 300);
        ImageIcon icon2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Normal_Button.png")));
        Image img2 = icon2.getImage();
        Image newimg2 = img2.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.setFocusPainted(false);
        button2.setOpaque(false);
        button2.setIcon(new ImageIcon(newimg2));
        button2.addActionListener(this::PlayMedium);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //add(Box.createRigidArea(new Dimension(0, 0)));

        JButton button3 = new JButton();
        button3.setSize(200, 50);
        button3.setLocation(250, 400);
        ImageIcon icon3 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Hard_Button.png")));
        Image img3 = icon3.getImage();
        Image newimg3 = img3.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.setFocusPainted(false);
        button3.setOpaque(false);
        button3.setIcon(new ImageIcon(newimg3));
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
