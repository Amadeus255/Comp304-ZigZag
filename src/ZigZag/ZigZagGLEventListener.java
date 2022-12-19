package ZigZag;

import Texture.TextureReader;

import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;
import java.util.ArrayList;
import java.util.BitSet;
import javax.media.opengl.glu.GLU;
import javax.swing.*;

public class ZigZagGLEventListener implements GLEventListener, MouseListener, KeyListener {

    int maxWidth = 900;
    int maxHeight = 900;

    ArrayList<Tile> tiles = new ArrayList<>();

    String[] textureNames = {"Back.png", "Ball1.png", "Tile.png"};
    TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
    int[] textures = new int[textureNames.length];

    /*
     5 means gun in array pos
     x and y coordinate for gun
     */
    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClearColor(0.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

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

    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer

        drawSprite(gl,0,0, 100,100,2);
        drawSprite(gl,70,70, 100,100,2);
        drawSprite(gl,140,140, 100,100,2);
        drawSprite(gl,210,210, 100,100,2);
        drawSprite(gl,280,280, 100,100,2);
        drawSprite(gl,350,350, 100,100,2);

        handleKeyPress();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

//    public void drawBackground(GL gl) {
//        gl.glEnable(GL.GL_BLEND);
//        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[0]);    // Turn Blending On
//
//        gl.glPushMatrix();
//        gl.glBegin(GL.GL_QUADS);
//
//        Vertex(gl);
//
//        gl.glEnd();
//        gl.glPopMatrix();
//        gl.glDisable(GL.GL_BLEND);
//    }

    public void drawSprite(GL gl, int x, int y, int width, int height, int texture) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[texture]);    // Turn Blending On
        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        gl.glRotated(45, 0, 0, 1);
        gl.glScaled( width / 2.0,  height / 2.0, 1);
        gl.glBegin(GL.GL_QUADS);

        Vertex(gl);

        gl.glEnd();
        gl.glPopMatrix();
        gl.glDisable(GL.GL_BLEND);
    }

    public void createMap() {

        int maxNumOfTiles = 3;
        int minNumOfTiles = 1;
        int numOfTiles = 0;


    }

    private void Vertex(GL gl) {

        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);

    }

    /*
     * KeyListener
     */
    public void handleKeyPress() {

    }

    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    @Override
    public void keyTyped(final KeyEvent event) {
        // don't care
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

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

    void setCanvas(GLCanvas glcanvas) {
    }
}
