class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return roman.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int num1 = 3749;
        System.out.println(solution.intToRoman(num1)); // Output: MMMDCCXLIX

        // Example 2
        int num2 = 58;
        System.out.println(solution.intToRoman(num2)); // Output: LVIII

        // Example 3
        int num3 = 1994;
        System.out.println(solution.intToRoman(num3)); // Output: MCMXCIV
    }
}