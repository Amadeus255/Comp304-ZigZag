package ZigZag;

import Score.Score;
import Texture.TextureReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JFrame implements ActionListener {

    String textureNames[] = {"GameOver.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    Score scorei = ZigZagGLEventListener.score;

    public GameOver() {


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        score = new JLabel();
        score.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        user = new JTextField();
        user.setMaximumSize(new Dimension(400, 600));
        JLabel hScore = new JLabel();
        name = new JLabel("enter your name");
        name.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 30));
        //ok button
        JButton username = new JButton();
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Assets/Ok.png"));
        Image img1 = icon1.getImage();
        Image newimg1 = img1.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        username.setBorderPainted(false);
        username.setContentAreaFilled(false);
        username.setFocusPainted(false);
        username.setOpaque(false);
        username.setIcon(new ImageIcon(newimg1));
        username.addActionListener(this::Ok);


        JLabel label = new JLabel();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Assets/GameOver.png"));
        Image img2 = icon2.getImage();
        Image newimg2 = img2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newimg2));
        label.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        // play again button
        JButton button = new JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Assets/playagain.jpeg"));
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setIcon(new ImageIcon(newimg));
        button.addActionListener(this::Clicked);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        username.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        score.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());
        add(label);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(name);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(user);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(username);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(score);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(button);

        add(Box.createVerticalGlue());
        setTitle("Game Over");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);


    }

    public void Clicked(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new ZigZag().setVisible(true);


    }

    public void Ok(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        String f = user.getText();
        StringBuffer score1 = new StringBuffer(f + " your Score is : " + scorei.getCurrentScore());
        score.setText(score1.toString());


    }

    public static void s() {
        new GameOver();
    }
//    public  static void printScore(int score) {
//        System.out.println(score);


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private JTextField user;
    private JLabel yours;
    private JLabel score;
    private JLabel name;
}