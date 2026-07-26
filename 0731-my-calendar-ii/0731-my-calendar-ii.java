import java.util.*;

class MyCalendarTwo {

    // Stores all booked events
    List<int[]> bookings;

    // Stores intervals that are already double booked
    List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        // Step 1: Check if new event overlaps any double-booked interval
        // If yes -> Triple booking
        for (int[] interval : overlaps) {
            if (start < interval[1] && end > interval[0]) {
                return false;
            }
        }

        // Step 2: Find overlaps with existing bookings
        for (int[] booking : bookings) {

            if (start < booking[1] && end > booking[0]) {

                // Store intersection as a double-booked interval
                overlaps.add(new int[]{
                    Math.max(start, booking[0]),
                    Math.min(end, booking[1])
                });
            }
        }

        // Step 3: Add current booking
        bookings.add(new int[]{start, end});

        return true;
    }
}