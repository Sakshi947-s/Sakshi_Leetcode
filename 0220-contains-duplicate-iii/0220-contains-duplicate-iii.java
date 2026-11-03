import java.util.*;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        long size = (long) valueDiff + 1;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long bucket = num >= 0
                    ? num / size
                    : ((num + 1) / size) - 1;
            if (map.containsKey(bucket)) {
                return true;
            }
            if (map.containsKey(bucket - 1) &&
                num - map.get(bucket - 1) <= valueDiff) {
                return true;
            }
            if (map.containsKey(bucket + 1) &&
                map.get(bucket + 1) - num <= valueDiff) {
                return true;
            }
            map.put(bucket, num);
            if (i >= indexDiff) {
                long oldNum = nums[i - indexDiff];
                long oldBucket = oldNum >= 0
                        ? oldNum / size
                        : ((oldNum + 1) / size) - 1;
                map.remove(oldBucket);
            }
        }
        return false;
    }
}