# Rate Limiting: A Complete Guide to Controlling Traffic in Your System

In today’s digital world, controlling how clients interact with your system is crucial. Too many requests at once can overload your servers, degrade performance, or even cause downtime. That’s where **rate limiting** comes into play.

---

## What is Rate Limiting?

Rate limiting is a control mechanism used to restrict the number of requests or actions a user, client, or system can perform within a specific timeframe. In simple words, it **throttles requests that exceed a predefined limit**, protecting your system from overloads and misuse.

---

## Why Do We Need Rate Limiters?

There are multiple reasons why rate limiters are essential:

- **Fair resource usage:** Ensures all users get a fair share when resources are shared.
- **Prevent DoS attacks:** Mitigates both intentional and accidental spikes.
- **Cost control:** Prevents runaway API calls or experiments that could incur large bills.
- **Example:** Twitter limits the number of tweets to 300 per 3 hours.

---

## Designing a Rate Limiter

Before implementing a rate limiter, ask yourself the following questions:

- Are we designing a **client-side** or **server-side** rate limiter?
- Do we need to **inform users** when their requests are throttled?
- Is this for a **single server** or a **distributed system**?
- What are we limiting — **users, IP addresses, API keys, or endpoints**?
- What is the **limit per time window**?
- What should happen if the limit is exceeded — **reject, delay, or queue**?

---

### Functional Requirements

- Limit the number of requests per user.
- Check each request against the configured limit.
- Notify clients when the limit is exceeded.
- Support multiple **rate limiting algorithms**:
    - Fixed Window Counter
    - Sliding Window Log
    - Sliding Window Counter
    - Leaky Bucket
    - Token Bucket

### Non-Functional Requirements

- **Availability:** Protect the system without downtime.
- **Scalability:** Handle increasing requests over time.
- **Low latency:** Rate limiting should not slow responses.
- **High fault tolerance:** Failure of the limiter (e.g., cache server down) should not affect the system.

---

## Types of Throttling

1. **Hard Throttling:** Strict enforcement; requests beyond the limit are rejected immediately.
2. **Soft Throttling:** Loosely enforced; excess requests are delayed, logged, or allowed with warnings.
3. **Elastic/Dynamic Throttling:** Adjusts limits dynamically based on system load or traffic patterns.

---

## Where to Place a Rate Limiter

- **Client-side:** Unreliable; can be tampered with easily.
- **Server-side:** Safer; controls requests as they reach the server.
- **Middleware:** Acts as a middle layer to throttle requests.
- **API Gateway:** Common for authentication, IP whitelisting, SSL termination, and rate limiting.

> **Tip:** Placement depends on system architecture, priorities, and resources.

---

## Popular Rate Limiter Algorithms

### 1. Token Bucket Algorithm

- Bucket holds tokens; tokens are added at a fixed rate.
- Request consumes a token; if none are available, request is rejected.
- **Pros:** Handles bursts well; flexible.
- **Cons:** Slightly complex to implement.
- **Use case:** APIs where temporary bursts are acceptable.

### 2. Leaky Bucket Algorithm

- Works like a bucket with a hole at the bottom. Requests leave at a fixed rate. Overflowing requests are discarded.
- Can be implemented using a **FIFO queue**.
- **Pros:** Smooths traffic; prevents spikes.
- **Cons:** Does not naturally allow bursts; needs memory for queue.

### 3. Fixed Window Counter

- Divides time into equal blocks (windows). Counter tracks requests. Requests exceeding limit are rejected until next window.
- **Pros:** Easy to implement; low memory usage.
- **Cons:** Can cause bursting at window boundaries.

### 4. Sliding Window Log

- Stores exact timestamps of all requests in a cache like Redis. Old requests outside window are removed.
- **Pros:** Accurate; handles bursts smoothly.
- **Cons:** Memory-intensive for high traffic.

### 5. Sliding Window Counter

- Hybrid of Fixed Window and Sliding Window Log.
- Calculates weighted counts from the last window.

**Formula:**  

weight = (100 - elapsed_percentage)% * lastWindowRequests + currentWindowRequests
