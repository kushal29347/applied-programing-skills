class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Corner cases: 
        // 1. If k == 0, Alice never draws, so her score is 0 <= n (probability = 1.0).
        // 2. If n >= k + maxPts, Alice's maximum possible final score is k - 1 + maxPts,
        //    which is always <= n (probability = 1.0).
        if (k == 0 || n >= k + maxPts) {
            return 1.0;
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0;
        double totalProbability = 0.0;

        for (int i = 1; i <= n; i++) {
            // dp[i] is the average of the probabilities of the previous maxPts states
            dp[i] = windowSum / maxPts;

            // If i < k, Alice can continue drawing from state i
            if (i < k) {
                windowSum += dp[i];
            } else {
                // If i >= k, Alice stops drawing, so this becomes a valid final score
                totalProbability += dp[i];
            }

            // Remove state (i - maxPts) as it slides out of the maxPts window
            if (i >= maxPts) {
                windowSum -= dp[i - maxPts];
            }
        }

        return totalProbability;
    }
}