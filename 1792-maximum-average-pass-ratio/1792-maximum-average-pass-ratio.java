class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            double gain = gainByAddingStudent(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }
        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            extraStudents--;

            double newGain = gainByAddingStudent(pass, total);
            maxHeap.offer(new double[]{newGain, pass, total});
        }

        double totalAverage = 0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalAverage += (double) pass / total;
        }

        return totalAverage / classes.length;
    }
    private double gainByAddingStudent(int pass, int total) {
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }
}
