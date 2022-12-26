package ZigZag;

import Texture.TextureReader;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

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
        //initComponents();
        //setSize(800,800);
        GLCanvas glcanvas;
        //Animator animator;

        StartGlEventListener listener = new StartGlEventListener();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        glcanvas.addKeyListener(listener);
        listener.setCanvas(glcanvas);

        add(glcanvas, BorderLayout.CENTER);

        //animator = new FPSAnimator(60);
        //animator.add(glcanvas);
        //animator.start();

        setTitle("ZigZag");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  /* private void initComponents() {

        jButton1 = new javax.swing.JButton();
        //jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(getClass().getResource("/ZigZag/play.png"));
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance(100,50,Image.SCALE_SMOOTH);
        jButton1.setIcon(new ImageIcon(newimg));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        //jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ZigZag/b8.png"))); // NOI18N
        //jButton2.addActionListener(new java.awt.event.ActionListener() {
          //  public void actionPerformed(java.awt.event.ActionEvent evt) {
            //    jButton2ActionPerformed(evt);
            //}
        //});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1))
                        )
        );
                                        //.addComponent(jButton2))
                                //.addContainerGap(441, Short.MAX_VALUE))
       // );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }
    // </editor-fold>//GEN-END:initComponents
   */

    private void jButton2ActionPerformed(ActionEvent evt) {
    }


    private void jButton1ActionPerformed(ActionEvent evt) {
        //   new ZigZag();
    }

  /*  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ZigZag().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new GameOver().setVisible(true);
//        new Second().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
*/

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // End of variables declaration//GEN-END:variables

    public class StartGlEventListener implements GLEventListener, MouseListener, KeyListener {

        int maxWidth = 700;
        int maxHeight = 1000;

        String[] textureNames = {"background.png", "play.png"};
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

            mouseX = (int) ((x / width) * maxWidth) - maxWidth / 2;
            mouseY = maxHeight / 2 - ((int) ((y / height) * maxHeight));

            if (mouseX > -90 && mouseX < 90 && mouseY > -70 && mouseY < 70)
                //System.out.println("Test");
                new ChoseLevel();
            dispose();
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
            gl.glOrtho(-350, 350, -500, 500, -1, 1);

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
            gl.glScaled(width / 4, height / 4, 1);
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

        public void setCanvas(GLCanvas glcanvas) {
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