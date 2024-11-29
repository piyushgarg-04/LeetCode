class Solution {
    public int splitNum(int num) {
      char[] digits = String.valueOf(num).toCharArray();

        Arrays.sort(digits);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                num1.append(digits[i]);
            } else {
                num2.append(digits[i]);
            }
        }

        int number1 = num1.length() > 0 ? Integer.parseInt(num1.toString()) : 0;
        int number2 = num2.length() > 0 ? Integer.parseInt(num2.toString()) : 0;

        return number1 + number2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int num1 = 4325;
        System.out.println("Output for 4325: " + solution.splitNum(num1));

        // Test case 2
        int num2 = 687;
        System.out.println("Output for 687: " + solution.splitNum(num2)); 
    }
}