package ZigZag;


import com.sun.opengl.util.*;

import java.awt.*;
import java.io.File;
import javax.media.opengl.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class ZigZag extends JFrame {

    public ZigZag(int speed) {
        try {
            String soundName = "/Assets/sound.wav";
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(soundName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }


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
        listener.setCanvas();
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
