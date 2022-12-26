package ZigZag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartGame extends JFrame implements ActionListener {

    public StartGame(){

        setLayout(null);
        JLabel label1 =new JLabel(new ImageIcon(getClass().getResource("/Assets/background.png")));
        label1.setBounds(0,0,850,450);

        JLabel label =new JLabel("ZigZag");
        label.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        label.setBounds(350,20,200,50);


        JLabel button = new JLabel("Start Game");
        button.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        button.setBounds(300,200,300,100);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                new ChoseLevel().setVisible(true);;
            }
        });

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        //add(Box.createVerticalGlue());
        add(label);
        //add(Box.createRigidArea(new Dimension(0, 20)));
        add(button);
        add(label1);
        //add(Box.createVerticalGlue());

        setTitle("Start Game");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850 ,450);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
    }

    public void Play() {
        // TODO add your handling code here:
       // new ZigZag().setVisible(true);

    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartGame().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
