package InterviewQuestion.DesignRateLimiter;

import java.time.Instant;

public class FixedWindowAlgorithm {
    private final long windowSize;  // Size of each window in seconds
    private final long maxRequestsPerWindow; // Maximum number of requests allowed per window
    private long currentWindowStart;         // Start time of the current window
    private long requestCount;               // Number of requests in the current window

    public FixedWindowAlgorithm(long windowSizeInSeconds, long maxRequestsPerWindow) {
        this.windowSize = windowSizeInSeconds;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.requestCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();

        if (now - currentWindowStart >= windowSize) {
            currentWindowStart = now;
            requestCount = 0;
        }

        if (requestCount < maxRequestsPerWindow) {
            requestCount++;
            return true;     // Allow the request
        }
        return false;
    }
}

