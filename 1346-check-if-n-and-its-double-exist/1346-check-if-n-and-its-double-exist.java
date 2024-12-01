import java.util.HashSet;

public class Solution {
    public static boolean checkIfExist(int[] arr) {
        // Create a HashSet to store the elements of the array
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            // Check if num * 2 or num / 2 (if num is even) already exists in the set
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            // Add the current number to the set
            set.add(num);
        }
        
        // If no such pair exists, return false
        return false;
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {10, 2, 5, 3};
        System.out.println(checkIfExist(arr1)); // Output: true

        // Example 2
        int[] arr2 = {3, 1, 7, 11};
        System.out.println(checkIfExist(arr2)); // Output: false
    }
}
