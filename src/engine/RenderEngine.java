/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import components.Collider;
import components.GameObject;
import components.KeyReader;
import debugtools.FrameRate;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import util.Pair;

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
    private Pair size;
    private ArrayList<GameObject> toDelete;
    
    // Varaible to manage debugging tools
    private boolean debugEnabled = false; // Let the end user configure this 
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
        toDelete = new ArrayList<>();
        size = new Pair(640, 480);
        
        if (debugEnabled) {
            frameRate = new FrameRate();
        }
    }
    
    @Override
    protected void finalize () {
        self = null;
    }

    public void addGameObject(GameObject obj) {
        gameObjects.add(obj);
        obj.setOwner(this);
    }

    public void addToDeleteList(GameObject g) {
        toDelete.add(g);
    }
    
    public void setDebug(boolean val) {
        this.debugEnabled = val;
    }
    
    public void setSize(int x, int y) {
        size.setPair(x, y);
    }
    
    public void setUpEngine() {

        Canvas canvas = new Canvas();
        canvas.setSize(size.getFirst(), size.getSecond());
        canvas.setBackground(Color.white);
        canvas.setIgnoreRepaint(true);
        
        this.getContentPane().add(canvas);
        this.pack();
        
        canvas.createBufferStrategy(DISPOSE_ON_CLOSE);
        buffer = canvas.getBufferStrategy();

        this.setTitle("Game");
        this.setIgnoreRepaint(true);
        this.setSize(size.getSecond(), size.getSecond());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding in the keylistener
        keyReader = KeyReader.createKeyReader();
        this.addKeyListener(keyReader);
        canvas.addKeyListener(keyReader);
        
        gameThread = new Thread(this);
        gameThread.start();
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
    
    private void render(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        
        // This entire block is the collision check algorithm. basic n^2 comparison
        gameObjects.forEach((gameObject) -> {
            Collider col = gameObject.getCollider();
            if (col != null)
                col.setColliding(false);
        });
        
        gameObjects.forEach((gameObject) -> {
            Collider gameObjectCollider = gameObject.getCollider();
            if (gameObjectCollider != null && !gameObjectCollider.isStatic()) {                
                gameObjects.forEach((secondGameObject) -> {    
                    Collider possibleCollider = secondGameObject.getCollider();
                    if (possibleCollider != null && 
                        gameObjectCollider != possibleCollider) {
                        gameObjectCollider.checkCollision(possibleCollider);
                            
                    }
                });
            }
        });
        
        gameObjects.forEach((gameObject) -> {
            gameObject.update(); // Running update before drawing each frame
            graphics2d.drawImage(
                    gameObject.getSprite(),
                    gameObject.getX(),
                    gameObject.getY(),
                    this
            );
            
            // Key Press Actions
            if (keyReader.isPressed()) {
                gameObject.onKeyPressed(keyReader.currentPressedKey());
            }
            if (keyReader.isPressedOnThisFrame()) {
                gameObject.onKeyDown(keyReader.currentPressedKey());
            }
                
            // Debug draw for colliders
            if (debugEnabled) {
                Collider col = gameObject.getCollider();
                if (col != null) {
                    if (col.isColliding())
                        graphics2d.setColor(Color.red);
                    else
                        graphics2d.setColor(Color.blue);

                    graphics2d.drawRect(
                            col.getAbsoluteX(), 
                            col.getAbsoluteY(),
                            col.getWidth(), 
                            col.getHeight()
                    );
                }
            }
        });
        keyReader.setPressOff(); //A botch to keep the keydown event run for
                                   // a single frame
        
        if (debugEnabled) {
            frameRate.drawFrameRate(graphics);
        }
        
        if (!toDelete.isEmpty()) {
            toDelete.forEach((obj) -> {
                gameObjects.remove(obj);
            });
            toDelete.clear();
        }
    }

    public void stop () {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
