package ZigZag;

import Score.Score;
import Texture.TextureReader;
import Texture.*;
import com.sun.opengl.util.j2d.TextRenderer;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.*;

public class ZigZagGLEventListener implements GLEventListener, MouseListener, KeyListener {

    public static Score score = new Score();
    GameOver gameover=new GameOver();
    boolean paused = false;
    int maxWidth = 700;
    int maxHeight = 1000;
    int tileType;
    boolean removed = false;
    int flag = 0;
    boolean gameOver = false;

    int frame = 0;
    double x = 0;
    double y = 0;
    double speed = 3;
    double xBall = -70;
    double yBall = -70;
    TextRenderer n = new TextRenderer(Font.decode("PLAIN"));


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

    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        frame++;
        if (paused) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {

            createMap();
            drawMap(gl);
            drawBall(gl, xBall, yBall, 50, 50, 1);
            score.updateScore((float) speed);
        }
        if (gameOver) {
            score.storeSessionScore();
            gameover.setVisible(gameOver);
            MainMenu.zigzag.setVisible(false);
        }
        System.out.println(score.getCurrentScore());
        handleKeyPress();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void createMap() {

        tiles.add(new Tile(x, y, tileType));
        Random random = new Random();
        double randomNumber = random.nextDouble();

        if (randomNumber < 0.5) {
            tileType = 0;
        } else {
            tileType = 1;
        }

        if (x < -250) {
            tileType = 1;
            x += 70;
            y += 69 - speed;

        } else if (x > 250) {
            tileType = 0;
            x -= 70;
            y += 69 - speed;

        } else if (x >= -250 && x < 250) {
            if (tileType == 1) {
                x += 70;

            } else {
                x -= 70;

            }
            y += 69 - speed;
        }
    }

    public void drawMap(GL gl) {
        for (Tile tile : tiles) {
            drawTile(gl, tile.x, tile.y, tile.angle, 100, 100, 2);
            tile.y -= speed;
            tile.invalidate();

            if ((0 <= Math.abs(yBall - tile.y)) && Math.abs(yBall - tile.y) <= 25) {
                if (!(0 <= Math.abs(xBall - tile.x) && Math.abs(xBall - tile.x) <= 85)) {
                   // n.endRendering();
                    gameOver=true;


                    //goes to score screen later
                }
            }
        }


        Iterator<Tile> itr = tiles.iterator();
        while (itr.hasNext()) {
            Tile b = itr.next();
            if (b.invisible) {
                itr.remove();
                removed = true;
                break;
            }
        }

    }

    public void drawTile(GL gl, double x, double y, int angle, int width, int height, int texture) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[texture]);    // Turn Blending On
        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        gl.glRotated(angle, 0, 0, 1);
        gl.glScaled(width / 2.0, height / 2.0, 1);
        gl.glBegin(GL.GL_QUADS);

        Vertex(gl);

        gl.glEnd();
        gl.glPopMatrix();
        gl.glDisable(GL.GL_BLEND);
    }

    public void drawBall(GL gl, double x, double y, int width, int height, int texture) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[texture]);    // Turn Blending On
        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        if (flag == 0) {
            xBall += speed;
        } else {
            xBall -= speed;
        }
        gl.glRotated(-45, 0, 0, 1);
        gl.glScaled(width / 2.0, height / 2.0, 1);
        gl.glBegin(GL.GL_QUADS);

        Vertex(gl);

        gl.glEnd();
        gl.glPopMatrix();
        gl.glDisable(GL.GL_BLEND);
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
        if (isKeyPressed(KeyEvent.VK_SPACE)) {
            paused = !paused;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
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

        if (flag == 0) {
            flag = 1;
        } else {
            flag = 0;
        }

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
