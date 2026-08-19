class Solution {
    static boolean isAvailable(Set<Integer> bookedSeats, int seat) {
        return !bookedSeats.contains(seat);
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int seat = reservedSeat[1];

            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }

            map.get(row).add(seat);
        }
        int result = (n - map.size()) * 2;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {

            int row = entry.getKey();
            Set<Integer> bookedSeats = entry.getValue();

            boolean grpA = isAvailable(bookedSeats, 2) &&
                    isAvailable(bookedSeats, 3) &&
                    isAvailable(bookedSeats, 4) &&
                    isAvailable(bookedSeats, 5);

            boolean grpB = isAvailable(bookedSeats, 4) &&
                    isAvailable(bookedSeats, 5) &&
                    isAvailable(bookedSeats, 6) &&
                    isAvailable(bookedSeats, 7);

            boolean grpC = isAvailable(bookedSeats, 6) &&
                    isAvailable(bookedSeats, 7) &&
                    isAvailable(bookedSeats, 8) &&
                    isAvailable(bookedSeats, 9);

            if (grpA && grpC) {
                result += 2;
            } else if (grpA || grpB || grpC) {
                result += 1;
            }
        }

        return result;
    }
}