package game;

import display.Display;
import phases.Phase;
import phases.PhaseManager;
import phases.PhaseMenu;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Core implements Runnable {

    private int width;
    private int height;
    private String title;

    private boolean isRunning;
    private Thread thread;
    private Display display;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private static Phase phase;

    //Testing
    private int a;


    public Core (String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        this.isRunning = false;
    }

    @Override
    public void run() {
        this.initialization();

        while (this.isRunning) {
            this.update();
            this.render();
        }

        this.stop();
    }

    public synchronized void start() {
        if (this.isRunning){
            return;
        }

        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public synchronized void stop() {
        if (!this.isRunning){
            return;
        }

        this.isRunning = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initialization() {
        this.display = new Display(this.title, this.width, this.height);
        this.phase = PhaseManager.getCurrentPhase();

        //Testing
        a = 10;

    }

    private void update() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.phase.update();

        //Testing
        a+=1;

    }

    private void render() {
        if (this.bufferStrategy == null){
            this.display.getCanvas().createBufferStrategy(2);
        }

        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        this.graphics = this.bufferStrategy.getDrawGraphics();

        this.phase.render(this.graphics);

        //Testing
        this.graphics.fillRect(a, 10, 20, 20);


        this.bufferStrategy.show();
        this.graphics.clearRect(0, 0, this.width, this.height);
        this.graphics.dispose();
    }



}
