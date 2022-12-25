package ZigZag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JFrame implements ActionListener {

    int scorei = ZigZagGLEventListener.score;

  public GameOver(){

      setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
      score= new JLabel();
      user = new JTextField();
      user.setMaximumSize(new Dimension(400,600));
      user.setHorizontalAlignment(10);
      JLabel hScore = new JLabel();
      name = new JLabel("enter your name");
      name.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 30));
      JButton username = new JButton("Ok");
      username.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
      username.setSize(20,20);
      username.addActionListener(this::Ok);
      JLabel label =new JLabel("Game Over");
      label.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
      // play again button
      JButton button = new JButton("Play Again");
      button.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
      button.setSize(20,20);
      button.addActionListener(this::Clicked);
      label.setAlignmentX(Component.CENTER_ALIGNMENT);
      name.setAlignmentX(Component.CENTER_ALIGNMENT);
      username.setAlignmentX(Component.CENTER_ALIGNMENT);
      button.setAlignmentX(Component.CENTER_ALIGNMENT);
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

        String f=user.getText();
        StringBuffer score1 = new StringBuffer(f+"Your Score is : "+scorei);
         score.setText(score1.toString());
        score.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));



    }
    public static void s (){
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
