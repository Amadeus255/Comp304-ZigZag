package ZigZag;


import com.sun.opengl.util.*;

import java.awt.*;
import javax.media.opengl.*;
import javax.swing.*;

import static java.awt.Transparency.TRANSLUCENT;

public class ZigZag extends JFrame {

    public ZigZag(int speed) {

        GLCanvas glcanvas;
        Animator animator;
        ZigZagGLEventListener listener = new ZigZagGLEventListener();
        //listener.ShowCurrentScore.setBounds(5,5,100,20);
        listener.ShowCurrentScore.setMaximumSize(new Dimension(45,50));
        listener.ShowCurrentScore.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 19));

        add(listener.ShowCurrentScore,BorderLayout.NORTH);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.addMouseListener(listener);
        listener.setCanvas(glcanvas);
        listener.speed = speed;
        add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(30);
        animator.add(glcanvas);
        animator.start();

        setTitle("ZigZag");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }
}
