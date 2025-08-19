package InterviewQuestion.DesignRateLimiter;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucketAlgorithm {
    private final long capacity;       // max number of requests allowed at once (bucket size)
    private final long leakRate;       // requests per second
    private final Queue<Long> queue;   // FIFO queue to hold requests
    private long lastLeakTimestamp;    // last time requests leaked

    public LeakyBucketAlgorithm(long capacity, long leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.queue = new LinkedList<>();
        this.lastLeakTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        leakRequests();
        if (queue.size() < capacity) {
            queue.offer(System.nanoTime()); // add request to the queue
            return true;
        }
        return false; // bucket full → request dropped
    }

    private void leakRequests() {
        long now = System.nanoTime();
        double elapsedSeconds = (now - lastLeakTimestamp) / 1e9;
        long leaks = (long) (elapsedSeconds * leakRate);

        while (!queue.isEmpty() && leaks > 0) {
            queue.poll(); // remove oldest request
            leaks--;
        }

        if (elapsedSeconds >= 1.0 / leakRate) {
            lastLeakTimestamp = now;
        }
    }
}