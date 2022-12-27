package ZigZag;

import Texture.TextureReader;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Help extends JFrame implements ActionListener {

    public Help(){

        GLCanvas glcanvas;
        //Animator animator;

        HelpGLEventListener listener = new HelpGLEventListener();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        listener.setCanvas(glcanvas);

        add(glcanvas, BorderLayout.CENTER);
        // setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Help");
    }
    public class HelpGLEventListener implements GLEventListener {

        int maxWidth = 700;
        int maxHeight = 1000;

        String[] textureNames = {"help2.jpg"};
        TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
        int[] textures = new int[textureNames.length];

        private int mouseX, mouseY;
        private GLCanvas glc;

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
            gl.glOrtho(-250, 250, -250, 250, -1, 1);

        }

        @Override
        public void display(GLAutoDrawable glAutoDrawable) {

            GL gl = glAutoDrawable.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glEnable(GL.GL_TEXTURE_2D);

            DrawBackground(gl);

            gl.glDisable(GL.GL_TEXTURE_2D);


        }

        public void DrawBackground(GL gl) {
            gl.glEnable(GL.GL_BLEND);
            gl.glBindTexture(GL.GL_TEXTURE_2D, textures[0]);    // Turn Blending On

//        gl.glColor3f(0, 0.5f, 0.5f);
            gl.glPushMatrix();
            gl.glScaled(300, 300, 1);
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


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
