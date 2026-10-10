
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] covered = new boolean[101];
        int count = 0;
        for (List<Integer> car : nums) {
            int start = car.get(0);
            int end = car.get(1);
            for (int i = start; i <= end; i++) {
                if (!covered[i]) {
                    covered[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
