package game;

import audio.AudioAssets;
import display.Display;
import game.InputHandlers.MenuInputHandler;
import graphics.Assets;
import models.menus.PauseMenu;
import phases.Phase;
import phases.PhaseManager;

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
        Assets.initialization();
        AudioAssets.initialization();

        this.display = Display.getInstance();
        this.phase = PhaseManager.getCurrentPhase();
    }

    private void update() {
        this.phase = PhaseManager.getCurrentPhase();
        this.phase.update();
    }

    private void render() {
        if (this.bufferStrategy == null){
            this.display.getCanvas().createBufferStrategy(2);
        }

        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        this.graphics = this.bufferStrategy.getDrawGraphics();

        this.phase.render(this.graphics);

        this.bufferStrategy.show();
        this.graphics.clearRect(0, 0, this.width, this.height);
        this.graphics.dispose();
    }
}
