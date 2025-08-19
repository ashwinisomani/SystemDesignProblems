package InterviewQuestion.DesignRateLimiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLogAlgorithm {
    private final int maxRequests;       // maximum requests allowed
    private final long windowSize;
    private final Queue<Long> requestTimestamps;

    public SlidingWindowLogAlgorithm(int maxRequests, long windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.requestTimestamps = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        // Remove outdated timestamps outside the sliding window
        while (!requestTimestamps.isEmpty() && requestTimestamps.peek() <= currentTime - windowSize) {
            requestTimestamps.poll();
        }

        if (requestTimestamps.size() < maxRequests) {
            requestTimestamps.add(currentTime);
            return true;
        } else {
            return false;
        }
    }
}