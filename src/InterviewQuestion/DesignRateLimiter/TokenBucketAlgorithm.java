package InterviewQuestion.DesignRateLimiter;

public class TokenBucketAlgorithm {
    private final long capacity;    // max number of requests allowed at once (bucket size).
    private final long refillRate;  // requests per second
    private double currentTokens;
    private long lastRefillTimestamp; // last time requests leaked

    public TokenBucketAlgorithm (long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.currentTokens = capacity;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refillTokens();
        if (currentTokens >= 1) {
            currentTokens -= 1;
            return true;
        }
        return false;
    }

    private void refillTokens() {
        long now = System.nanoTime();
        double tokensToAdd = ((now - lastRefillTimestamp) / 1e9) * refillRate;
        currentTokens = Math.min(capacity, currentTokens + tokensToAdd);
        lastRefillTimestamp = now;
    }
}

