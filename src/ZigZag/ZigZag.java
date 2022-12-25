package ZigZag;


import com.sun.opengl.util.*;
import java.awt.*;
import javax.media.opengl.*;
import javax.swing.*;

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
        glcanvas.addMouseListener(listener);
        listener.setCanvas(glcanvas);

        add(glcanvas, BorderLayout.CENTER);

        animator = new FPSAnimator(60);
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
