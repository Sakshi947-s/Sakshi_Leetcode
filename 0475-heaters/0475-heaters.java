class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
        int left = 0;
        int right = heaters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] == house) {
                    radius = Math.max(radius, 0);
                    left = mid;
                    break;
                } 
                else if (heaters[mid] < house) {
                    left = mid + 1;
                } 
                else {
                    right = mid - 1;
                }
            }
            int distance = Integer.MAX_VALUE;

            if (left < heaters.length) {
                distance = Math.min(distance, Math.abs(house - heaters[left]));
            }

            if (left > 0) {
                distance = Math.min(distance, Math.abs(house - heaters[left - 1]));
            }
            radius = Math.max(radius, distance);
        }
        return radius;
    }
}

//     bruteforce
//         int radius = 0;
//         for (int house : houses) {
//             int minDistance = Integer.MAX_VALUE;
//             for (int heater : heaters) {
//                 int distance = Math.abs(house - heater);
//                 minDistance = Math.min(minDistance, distance);
//             }
//             radius = Math.max(radius, minDistance);
//         }
//         return radius;
//     }
// }
