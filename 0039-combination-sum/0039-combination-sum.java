class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(solution.combinationSum(candidates1, target1));

        // Example 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(solution.combinationSum(candidates2, target2));

        // Example 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(solution.combinationSum(candidates3, target3)); 
    }
}