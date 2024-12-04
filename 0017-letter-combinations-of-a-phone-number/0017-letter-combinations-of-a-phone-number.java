class Solution {
    public List<String> letterCombinations(String digits) {
     List<String> result =new ArrayList();
        if(digits==null || digits.length()==0) {
            return result;
        }
        String[] mappings={
            " ",
            " ",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        backtrack(result, mappings, digits, 0, new StringBuilder());
        return result;
    }
    private void backtrack(List<String> result, String[] mappings, String digits, int index, StringBuilder current){
     
    if (index==digits.length()){
        result.add(current.toString());
        return;
    }
    String letters= mappings[digits.charAt(index)-'0'];
    
    for(char letter: letters.toCharArray()){
        current.append(letter);
        backtrack(result, mappings, digits, index+1, current);
        current.deleteCharAt(current.length() - 1);
    }
}

public static void main (String[] args){
    Solution solution = new Solution();
    
    System.out.println(solution.letterCombinations("23"));
    System.out.println(solution.letterCombinations(" "));
    System.out.println(solution.letterCombinations("2"));
}
}