package ZigZag;

import Texture.TextureReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GameOver extends JFrame implements ActionListener {

    Score scorei = ZigZagGLEventListener.score;

    public GameOver() {


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        score = new JLabel();
        score.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 30));
        user = new JTextField();
        user.setMaximumSize(new Dimension(400, 600));
        highScore = new JLabel();
        highScore.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 30));
        name = new JLabel("Enter Your Name");
        name.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 30));
        //ok button
        JButton ok = new JButton();
        ImageIcon icon1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Ok.png")));
        Image img1 = icon1.getImage();
        Image newimg1 = img1.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ok.setBorderPainted(false);
        ok.setContentAreaFilled(false);
        ok.setFocusPainted(false);
        ok.setOpaque(false);
        ok.setIcon(new ImageIcon(newimg1));
        ok.addActionListener(this::Ok);


        JLabel gameOver = new JLabel();
        ImageIcon icon2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/GameOver.png")));
        Image img2 = icon2.getImage();
        Image newimg2 = img2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        gameOver.setIcon(new ImageIcon(newimg2));
        gameOver.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        // play again button
        JButton playAgain = new JButton();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/playagain.jpeg")));
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        playAgain.setBorderPainted(false);
        playAgain.setContentAreaFilled(false);
        playAgain.setFocusPainted(false);
        playAgain.setOpaque(false);
        playAgain.setIcon(new ImageIcon(newimg));
        playAgain.addActionListener(this::Clicked);
        gameOver.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
        score.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScore.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());
        add(gameOver);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(name);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(user);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(ok);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(score);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(highScore);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(playAgain);

        add(Box.createVerticalGlue());
        setTitle("Game Over");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setVisible(false);
        setFocusable(true);


    }

    public void Clicked(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        scorei.setCurrentSessionScore(0);
        scorei.setCurrentScore(0);
        ChoseLevel.zigzag.dispose();
        ChoseLevel c = new ChoseLevel();


    }

    public void Ok(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        String f = user.getText();
        score.setText(f + " Your Score Is : " + (int) scorei.getCurrentScore());
        highScore.setText(" The Highest Score Is : " +  scorei.getHighScore());


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private JTextField user;
    private JLabel yours;
    private JLabel score;
    private JLabel highScore;
    private JLabel name;
}