public class Stopwatch {
    
    private final long nanoSecondsPerSecond = 1000000000;
    private long startTime = 0;
    private long endTime = 0;
    private boolean isRunning = false;

    // Starts the stop watch
    public void startWatch() {
        this.startTime = System.nanoTime();
        this.isRunning = true;
    }

    // ends the stop watch
    public void endWatch() {
        this.endTime = System.nanoTime();
        this.isRunning = false;
    }

    // returns the elapsed time of the running stopwatch
    public double elapsedTime() {
        double difference = (double)(endTime - startTime);
        double resInSeconds = (difference / nanoSecondsPerSecond);
        if (resInSeconds < 0) return 0;
        return resInSeconds;
    }
}