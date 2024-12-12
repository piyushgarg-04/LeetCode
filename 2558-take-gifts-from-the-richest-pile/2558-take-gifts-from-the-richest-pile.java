import java.util.*;

public class Solution {
    public static long pickGifts(int[] gifts, int k) {
        long ans = 0;

        // Use a max heap in Java (PriorityQueue with reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to the heap
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform k operations
        for (int i = 0; i < k; ++i) {
            if (!maxHeap.isEmpty()) {
                int maxGift = maxHeap.poll(); // Get and remove the largest element
                int reducedGift = (int) Math.sqrt(maxGift); // Calculate the floor of the square root
                maxHeap.add(reducedGift); // Add the remaining gifts back to the heap
            }
        }

        // Sum up the remaining gifts
        while (!maxHeap.isEmpty()) {
            ans += maxHeap.poll();
        }

        return ans; // Return the total as a long
    }

    public static void main(String[] args) {
        // Example input
        int[] gifts = {411042986, 697316006, 569259488, 665293106, 728558122, 395308016, 962051539, 449602622, 225273018, 421053664, 772795795, 42557563, 640312042, 791181812, 239411012, 610918759, 7894884, 951279693, 478806887, 792321489};
        int k = 630;

        System.out.println(pickGifts(gifts, k)); // Expected output: 2192086545
    }
}
