class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); 
        
        for(int i=0; i<n; i++){
             while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                 int index = stack.pop();
                 answer[index] = prices[index] - prices[i];
             }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index= stack.pop();
            answer[index]= prices[index];
        }
        return answer;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        
        int[] prices1={8,4,6,2,3};
        int[] result1 = solution.finalPrices(prices1);
        System.out.print("Output 1: ");
        for (int price : result1){
            System.out.print(price + " ");
        }
        System.out.println();
        
        int[] prices2={1,2,3,4,5};
        int[] result2 = solution.finalPrices(prices2);
        System.out.print("Output 2: ");
        for (int price : result2){
            System.out.print(price + " ");
        }
         System.out.println();
        
        int[] prices3={10,1,1,6};
        int[] result3 = solution.finalPrices(prices3);
        System.out.print("Output 3: ");
        for (int price : result3){
            System.out.print(price + " ");
        }
        System.out.println();
    }
}