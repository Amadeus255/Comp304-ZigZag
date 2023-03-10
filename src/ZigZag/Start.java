package ZigZag;

import Texture.TextureReader;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * @author moham
 */
public class Start extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form NewJFrame1
     */
    public Start() {
        GLCanvas glcanvas;

        StartGlEventListener listener = new StartGlEventListener();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        glcanvas.addKeyListener(listener);
        listener.setCanvas();

        add(glcanvas, BorderLayout.CENTER);


        setTitle("ZigZag");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }


    public static void main(String[] args) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // End of variables declaration//GEN-END:variables

    public class StartGlEventListener implements GLEventListener, MouseListener, KeyListener {

        int maxWidth = 700;
        int maxHeight = 1000;

        String[] textureNames = {"background.png", "Play.png", "help.png"};
        TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
        int[] textures = new int[textureNames.length];

        private int mouseX, mouseY;
        private GLCanvas glc;

        @Override
        public void mouseClicked(MouseEvent e) {
            double x = e.getX();
            double y = e.getY();
            Component c = e.getComponent();
            double width = c.getWidth();
            double height = c.getHeight();

            mouseX = (int) ((x / width) * maxWidth);
            mouseY = ((int) ((y / height) * maxHeight));
            mouseY = maxHeight - mouseY;

            if (mouseY > 204 && mouseX < 495 && mouseY > 417 && mouseY < 579) {
                new ChoseLevel();
                dispose();
            } else if (mouseX > 538 && mouseX < 660 && mouseY > 105 && mouseY < 222) {
                new Help();
            }
            //glc.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void init(GLAutoDrawable glAutoDrawable) {

            GL gl = glAutoDrawable.getGL();
            gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

            gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
            gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
            gl.glGenTextures(textureNames.length, textures, 0);

            for (int i = 0; i < textureNames.length; i++) {
                try {
                    texture[i] = TextureReader.readTexture("Assets" + "//" + textureNames[i], true);
                    gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                    new GLU().gluBuild2DMipmaps(
                            GL.GL_TEXTURE_2D,
                            GL.GL_RGBA, // Internal Texel Format,
                            texture[i].getWidth(), texture[i].getHeight(),
                            GL.GL_RGBA, // External format from image,
                            GL.GL_UNSIGNED_BYTE,
                            texture[i].getPixels() // Imagedata
                    );
                } catch (IOException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
            gl.glLoadIdentity();
            gl.glOrtho(-maxWidth / 2.0, maxWidth / 2.0, -maxHeight / 2.0, maxHeight / 2.0, -1, 1);

        }

        @Override
        public void display(GLAutoDrawable glAutoDrawable) {

            GL gl = glAutoDrawable.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glEnable(GL.GL_TEXTURE_2D);

            DrawBackground(gl);

            gl.glPushMatrix();
            DrawBotton(gl, 0, 0, 600, 400, 1);
            gl.glPopMatrix();

            gl.glPushMatrix();
            DrawBotton(gl, 250, -350, 300, 300, 2);
            gl.glPopMatrix();

            gl.glDisable(GL.GL_TEXTURE_2D);


        }

        public void DrawBackground(GL gl) {
            gl.glEnable(GL.GL_BLEND);
            gl.glBindTexture(GL.GL_TEXTURE_2D, textures[0]);    // Turn Blending On

//        gl.glColor3f(0, 0.5f, 0.5f);
            gl.glPushMatrix();
            gl.glScaled(700, 1000, 1);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
            gl.glTexCoord2f(0.0f, 0.0f);
            gl.glVertex3f(-1.0f, -1.0f, -1.0f);
            gl.glTexCoord2f(1.0f, 0.0f);
            gl.glVertex3f(1.0f, -1.0f, -1.0f);
            gl.glTexCoord2f(1.0f, 1.0f);
            gl.glVertex3f(1.0f, 1.0f, -1.0f);
            gl.glTexCoord2f(0.0f, 1.0f);
            gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
            gl.glPopMatrix();

            gl.glDisable(GL.GL_BLEND);
        }

        public void DrawBotton(GL gl, int x, int y, int width, int height, int index) {
            gl.glEnable(GL.GL_BLEND);
            gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);    // Turn Blending On


//        gl.glColor3f(0, 0.5f, 0.5f);
            gl.glPushMatrix();
            gl.glTranslated(x, y, 0);
            gl.glScaled(width / 4.0, height / 4.0, 1);
            //gl.glScaled(400, 400, 1);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
            gl.glTexCoord2f(0.0f, 0.0f);
            gl.glVertex3f(-1.0f, -1.0f, -1.0f);
            gl.glTexCoord2f(1.0f, 0.0f);
            gl.glVertex3f(1.0f, -1.0f, -1.0f);
            gl.glTexCoord2f(1.0f, 1.0f);
            gl.glVertex3f(1.0f, 1.0f, -1.0f);
            gl.glTexCoord2f(0.0f, 1.0f);
            gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
            gl.glPopMatrix();

            gl.glDisable(GL.GL_BLEND);
        }

        @Override
        public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

        }

        @Override
        public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

        }

        public void setCanvas() {
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
