package ZigZag;


import Texture.TextureReader;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ChoseLevel extends JFrame implements ActionListener{
    static ZigZag zigzag ;
    public ChoseLevel(){

        setLayout(null);
        JLabel label1 =new JLabel(new ImageIcon(getClass().getResource("/Assets/background.png")));
        label1.setBounds(0,0,850,450);

        setTitle("Start Game");
        //getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        //setFocusable(true);

        JButton button1 = new JButton("Easy");
        button1.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        button1.setSize(200,100);
        button1.setLocation(250,100);
        button1.addActionListener(this::Play);
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(button1);


        JButton button2 = new JButton("Medium");
        button2.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        button2.setSize(200,100);
        button2.setLocation(250,300);
        button2.addActionListener(this::Play);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //add(Box.createRigidArea(new Dimension(0, 0)));

        JButton button3 = new JButton("Hard");
        button3.setFont(new java.awt.Font("Calligrapher", Font.BOLD, 40));
        button3.setSize(200,100);
        button3.setLocation(250,500);
        button3.addActionListener(this::Play);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //add(Box.createRigidArea(new Dimension(0, -10)));


        //add(button1);
       add(button2);
       add(button3);
        add(label1);


    }

    private void Play(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
      zigzag = new ZigZag(3);
      zigzag.setVisible(true);

    }
    private void PlayMedium(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        zigzag=new ZigZag(5);
        zigzag.setVisible(true);

    }
    private void PlayHard(
            java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        zigzag=new ZigZag(7);
        zigzag.setVisible(true);

    }
    public class ChoseLevelGLEventListener implements GLEventListener{


        String[] textureNames = {"background.png"};
        TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
        int[] textures = new int[textureNames.length];


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
            gl.glOrtho(-350, 350, -350, 350, -1, 1);

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
            gl.glScaled(400, 400, 1);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String args[]){
        new ChoseLevel().setVisible(true);
    }
}
