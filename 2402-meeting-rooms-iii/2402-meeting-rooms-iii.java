class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );
        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                long[] room = busyRooms.poll();
                freeRooms.offer((int) room[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] room = busyRooms.poll();
                long duration = end - start;
                long newEnd = room[0] + duration;

                busyRooms.offer(new long[]{newEnd, room[1]});
                count[(int) room[1]]++;
            }
        }

        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}