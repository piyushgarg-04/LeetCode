class Solution {
    public int[][] validArrangement(int[][] pairs) {
         Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }
        int startNode = pairs[0][0]; // Default start node
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }
        List<Integer> path = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            while (graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()) {
                stack.push(graph.get(stack.peek()).poll());
            }
            path.add(stack.pop());
        }
        Collections.reverse(path);
        
        int[][] result = new int[pairs.length][2];
        for (int i = 0; i < path.size() - 1; i++) {
            result[i][0] = path.get(i);
            result[i][1] = path.get(i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
       Solution solution = new Solution();

        int[][] pairs1 = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        int[][] pairs2 = {{1, 3}, {3, 2}, {2, 1}};
        int[][] pairs3 = {{1, 2}, {1, 3}, {2, 1}};

        System.out.println(Arrays.deepToString(solution.validArrangement(pairs1)));
        System.out.println(Arrays.deepToString(solution.validArrangement(pairs2)));
        System.out.println(Arrays.deepToString(solution.validArrangement(pairs3)));
    }
}