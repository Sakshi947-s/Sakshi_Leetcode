import java.util.*;
class Solution {
    int[][] rects;
    int[] prefix;
    Random random;
    int total;
    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefix = new int[rects.length];
        this.random = new Random();
        total = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            int points = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            total += points;
            prefix[i] = total;
        }
    }
    public int[] pick() {
        int target = random.nextInt(total) + 1;
        int left = 0;
        int right = prefix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int[] r = rects[left];
        int pointsBefore = left == 0 ? 0 : prefix[left - 1];
        int offset = target - pointsBefore - 1;
        int width = r[2] - r[0] + 1;
        int x = r[0] + offset % width;
        int y = r[1] + offset / width;
        return new int[]{x, y};
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */