class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate total sum of the array first
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            // Elements to the right of index i
            int rightSum = totalSum - leftSum - nums[i];
            
            // Left count = i, Right count = n - 1 - i
            int leftDifference = (i * nums[i]) - leftSum;
            int rightDifference = rightSum - ((n - 1 - i) * nums[i]);
            
            result[i] = leftDifference + rightDifference;
            
            // Move current element to leftSum for the next iteration
            leftSum += nums[i];
        }
        
        return result;
    }
}