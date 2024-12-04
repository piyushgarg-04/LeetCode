import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Iterate over all possible hours (0-11) and minutes (0-59)
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Count the number of LEDs turned on (1s) in both hour and minute
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    // Format the time as "hour:minute"
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.readBinaryWatch(1));
        // Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

        System.out.println(solution.readBinaryWatch(9));
        // Output: []
    }
}
