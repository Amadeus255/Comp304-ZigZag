package ZigZag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class StartGame extends JFrame implements ActionListener {

    public StartGame(){

        setLayout(null);
        JLabel label1 =new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/background.png"))));
        label1.setBounds(0,0,700,700);

        JLabel label =new JLabel("ZigZag");
        label.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        label.setBounds(270,200,200,50);


        JLabel button = new JLabel("Start Game");
        button.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        button.setBounds(230,350,300,100);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                new ChoseLevel().setVisible(true);;
                dispose();
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
        setSize(700 ,1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
    }

    public static void main(String[] args) {

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
