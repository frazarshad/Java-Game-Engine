/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import components.GameObject;
import components.KeyReader;
import debugtools.FrameRate;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Fraz
 */
public final class RenderEngine extends JFrame implements Runnable {
    
    // Variables to manage state
    private static RenderEngine self = null; // for Singleton Pattern
    private boolean running;
    private BufferStrategy buffer;
    private Thread gameThread;
    
    // Varaible to manage debugging tools
    private boolean debugEnabled = true; // Let the end user configure this 
                                        // during runtime
    private FrameRate frameRate;

    // Variable to manage gamedata
    private final ArrayList<GameObject> gameObjects; // This is a list of all
                                        // gameobjects that are to be rendered
    private KeyReader keyReader;
    
    public static RenderEngine createEngine() {
        if (self == null) {
            self = new RenderEngine();
            return self;
        } else {
            return null;
        }
    }
    
    private RenderEngine() {
        gameObjects = new ArrayList<>();
        
        if (debugEnabled) {
            frameRate = new FrameRate();
        }
    }
    
    @Override
    protected void finalize () {
        self = null;
    }

    public void addGameObject(GameObject obj) {
        obj.setEngine(this);
        gameObjects.add(obj);
    }

    public void setDebug(boolean val) {
        this.debugEnabled = val;
    }
    
    public KeyReader getKeyReader() {
        return keyReader;
    }
    
    public void setUpEngine() {

        Canvas canvas = new Canvas();
        canvas.setSize(320, 240);
        canvas.setBackground(Color.white);
        canvas.setIgnoreRepaint(true);
        
        this.getContentPane().add(canvas);
        this.pack();
        
        canvas.createBufferStrategy(DISPOSE_ON_CLOSE);
        buffer = canvas.getBufferStrategy();

        this.setTitle("Game");
        this.setIgnoreRepaint(true);
        this.setSize(640, 480);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding in the keylistener
        keyReader = KeyReader.createKeyReader();
        this.addKeyListener(keyReader);
        
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void render(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        gameObjects.forEach((gameObject) -> {
            gameObject.update(); // Running update before drawing each frame
            graphics2d.drawImage(
                    gameObject.getSprite(),
                    gameObject.getX(),
                    gameObject.getY(),
                    this
            );
        });
        
        if (debugEnabled) {
            frameRate.drawFrameRate(graphics);
        }
    }

    @Override
    public void run() {
        running = true;
        // Running start function for each gameobject once
        gameObjects.forEach((gameObject) -> {
            gameObject.start();
        });
        
        while (running) {
            gameLoop();
        }
    }

    private void gameLoop() {
        do {
            do {
                Graphics g = null;
                try {
                    g = buffer.getDrawGraphics();
                    g.clearRect(0, 0, getWidth(), getHeight());

                    render(g);

                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (g != null) {
                        g.dispose();
                    }
                }
            } while (buffer.contentsRestored());
            buffer.show();
        } while (buffer.contentsLost());
    }
}
