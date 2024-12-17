class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int i=0; i<26; i++){
            if(freq[i]>0) {
                maxHeap.offer((char) (i+'a'));
            }
        }
        StringBuilder result = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            char first = maxHeap.poll();
            int count = Math.min(freq[first-'a'], repeatLimit);
            
            for(int i=0; i<count; i++){
                result.append(first);
            }
            freq[first-'a']-= count;
            if(freq[first-'a']>0){
                if(maxHeap.isEmpty()) break;
                char second = maxHeap.poll();
                
                result.append(second);
                freq[second - 'a']--;
                
                if (freq[second - 'a'] > 0) maxHeap.offer(second);
                maxHeap.offer(first);
            }
        }
         return result.toString();
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        
        String s1 = "cczazcc";
        int repeatLimit1 = 3;
        System.out.println(solution.repeatLimitedString(s1, repeatLimit1));
        
        String s2 = "aababab";
        int repeatLimit2 = 2;
        System.out.println(solution.repeatLimitedString(s2, repeatLimit2));
    }
}