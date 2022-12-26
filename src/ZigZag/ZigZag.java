package ZigZag;


import com.sun.opengl.util.*;

import java.awt.*;
import javax.media.opengl.*;
import javax.swing.*;

public class ZigZag extends JFrame {



    public ZigZag(int speed) {
        GLCanvas glcanvas;
        Animator animator;
        ZigZagGLEventListener listener = new ZigZagGLEventListener();
        listener.speed=speed;
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        listener.setCanvas(glcanvas);

        add(glcanvas, BorderLayout.CENTER);

        animator = new FPSAnimator(30);
        animator.add(glcanvas);
        animator.start();

        setTitle("ZigZag");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setVisible(false);
        setFocusable(true);
        glcanvas.requestFocus();
    }
}
