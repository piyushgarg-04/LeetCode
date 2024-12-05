class Solution {
    public boolean canChange(String start, String target) {
    if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }
        int i = 0, j = 0;
        int n = start.length();

        while (i < n && j < n) {
            
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;
            if (i == n || j == n) {
                return i == n && j == n;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false; // 'L' cannot move to the right
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false; // 'R' cannot move to the left
            }
            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println(solution.canChange("_L__R__R_", "L______RR")); // Output: true
        System.out.println(solution.canChange("R_L_", "__LR")); // Output: false
        System.out.println(solution.canChange("_R", "R_")); // Output: false
    }
}