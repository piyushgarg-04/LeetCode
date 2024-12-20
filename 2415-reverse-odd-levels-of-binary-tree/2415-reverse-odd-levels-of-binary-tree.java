/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
      if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOddLevel = false; // Indicates whether the current level is odd

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<TreeNode> nodesAtCurrentLevel = new ArrayList<>();

            // Collect all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                nodesAtCurrentLevel.add(currentNode);

                // Add children to the queue for the next level
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            // Reverse node values at the odd levels
            if (isOddLevel) {
                int left = 0, right = nodesAtCurrentLevel.size() - 1;
                while (left < right) {
                    int temp = nodesAtCurrentLevel.get(left).val;
                    nodesAtCurrentLevel.get(left).val = nodesAtCurrentLevel.get(right).val;
                    nodesAtCurrentLevel.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            // Toggle the level indicator
            isOddLevel = !isOddLevel;
        }

        return root;
    }

    // Helper method to print the tree (level-order traversal)
    public void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.val + " ");

            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
    Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(2,
                new TreeNode(3, new TreeNode(8), new TreeNode(13)),
                new TreeNode(5, new TreeNode(21), new TreeNode(34)));
        solution.reverseOddLevels(root1);
        solution.printTree(root1);

        // Example 2
        TreeNode root2 = new TreeNode(7,
                new TreeNode(13),
                new TreeNode(11));
        solution.reverseOddLevels(root2);
        solution.printTree(root2);

        // Example 3
        TreeNode root3 = new TreeNode(0,
                new TreeNode(1, new TreeNode(0, new TreeNode(1), new TreeNode(1)),
                        new TreeNode(0, new TreeNode(1), new TreeNode(1))),
                new TreeNode(2, new TreeNode(0, new TreeNode(2), new TreeNode(2)),
                        new TreeNode(0, new TreeNode(2), new TreeNode(2))));
        solution.reverseOddLevels(root3);
        solution.printTree(root3);  
    }
}