package ZigZag;


import com.sun.opengl.util.*;

import javax.media.opengl.*;
import javax.swing.*;
import java.awt.*;

public class ZigZag extends JFrame {

    public static void m() {
        new ZigZag();
    }

    public ZigZag() {
        GLCanvas glcanvas;
        Animator animator;

        ZigZagGLEventListener listener = new ZigZagGLEventListener();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
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
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }
}
