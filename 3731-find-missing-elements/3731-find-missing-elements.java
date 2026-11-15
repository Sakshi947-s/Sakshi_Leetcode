import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find minimum, maximum and store elements
        for (int num : nums) {
            set.add(num);

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        List<Integer> ans = new ArrayList<>();

        // Check every number in the range
        for (int i = min; i <= max; i++) {

            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}