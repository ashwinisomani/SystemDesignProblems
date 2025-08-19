package InterviewQuestion.DesignRateLimiter;

import java.time.Instant;

public class SlidingWindowCounterAlgorithm {
    private final long windowSize;   // Size of the sliding window in seconds
    private final long maxRequests;  // Maximum number of requests allowed in the window
    private long currentWindowStart;          // Start time of the current window
    private long previousWindowCount;         // Number of requests in the previous window
    private long currentWindowCount;          // Number of requests in the current window

    public SlidingWindowCounterAlgorithm(long windowSizeInSeconds, long maxRequestsPerWindow) {
        this.windowSize = windowSizeInSeconds;
        this.maxRequests = maxRequestsPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.previousWindowCount = 0;
        this.currentWindowCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        long timePassedInWindow = now - currentWindowStart;

        if (timePassedInWindow >= windowSize) {
            previousWindowCount = currentWindowCount;
            currentWindowCount = 0;
            currentWindowStart = now;
            timePassedInWindow = 0;
        }

        // Calculate the weighted count of requests
        double weightedCount = previousWindowCount * ((windowSize - timePassedInWindow) / (double) windowSize)
                + currentWindowCount;

        if (weightedCount < maxRequests) {
            currentWindowCount++;
            return true;
        }
        return false;
    }
}

