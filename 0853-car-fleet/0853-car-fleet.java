import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store each car's position and speed together.
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position in descending order.
        // Cars closest to the target come first.
        Arrays.sort(cars, (a, b) ->
            Integer.compare(b[0], a[0])
        );

        int fleets = 0;

        // Stores the arrival time of the fleet ahead.
        double lastFleetTime = 0.0;

        // Process cars from front to back.
        for (int i = 0; i < n; i++) {

            int pos = cars[i][0];
            int spd = cars[i][1];

            // Calculate the time required to reach the target.
            double currentTime = (double) (target - pos) / spd;

            // If this car needs more time than the fleet ahead,
            // it cannot catch that fleet before reaching the target.
            // Therefore, it forms a new fleet.
            if (currentTime > lastFleetTime) {

                fleets++;

                // Update the arrival time of the fleet now in front.
                lastFleetTime = currentTime;
            }

            // Otherwise, this car catches up with the fleet ahead.
            // The fleet count and lastFleetTime remain unchanged.
        }

        return fleets;
    }
}