package game;

public class Scheduling {
    private double timePerTick;
    private double deltaTime;
    private long now;
    private long lastTimeTicked;

    public Scheduling(int fps){
        this.timePerTick = 1_000_000_000.0 / fps;
        this.deltaTime = 0;
        this.lastTimeTicked = System.nanoTime();
    }

    public void update(){
        this.now = System.nanoTime();
        this.deltaTime += (this.now - this.lastTimeTicked) / this.timePerTick;
        this.lastTimeTicked = this.now;
    }

    public double getDeltaTime(){
        return deltaTime;
    }

    public void setDeltaTime(double deltaTime){
        this.deltaTime = deltaTime;
    }
}
