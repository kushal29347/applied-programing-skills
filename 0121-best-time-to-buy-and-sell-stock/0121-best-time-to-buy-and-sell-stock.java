class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update minPrice if we find a cheaper buying day
            if (price < minPrice) {
                minPrice = price;
            } 
            // Calculate potential profit and update maxProfit if it's higher
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}