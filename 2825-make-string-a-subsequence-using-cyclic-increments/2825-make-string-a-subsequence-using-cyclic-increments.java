class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m =str1.length();
        int n =str2.length();
        
        if(n>m) return false;
        int i=0 , j=0;
        while(i<m && j<n){
            char c1=str1.charAt(i);
            char c2=str2.charAt(j);
            
            if(c1==c2||(c1+ 1-'a')%26 +'a'==c2){
                j++;
            }
            i++;
        }
        return j==n;
    }
    public static void main(String [] args){
        Solution solution =new Solution();
        
        System.out.println(solution.canMakeSubsequence("abc", "ad")); // Output: true
        System.out.println(solution.canMakeSubsequence("zc", "ad")); // Output: true
        System.out.println(solution.canMakeSubsequence("ab", "d")); // Output: false
    }
}