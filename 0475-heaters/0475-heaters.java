class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        for (int house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int heater : heaters) {
                int distance = Math.abs(house - heater);
                minDistance = Math.min(minDistance, distance);
            }
            radius = Math.max(radius, minDistance);
        }
        return radius;
    }
}