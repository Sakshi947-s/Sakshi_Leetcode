class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long target = totalSum - x;
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return n;
        }
        int left = 0;
        int windowSum = 0;
        int maxLength = -1;
        for (int right = 0; right < n; right++) {
            windowSum += nums[right];
            while (windowSum > target && left <= right) {
                windowSum -= nums[left];
                left++;
            }
            if (windowSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        if (maxLength == -1) {
            return -1;
        }
        return n - maxLength;
    }
}