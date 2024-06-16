package interview.metapblms;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    public static int[][] kClosest(int[][] points, int k) {

        int[][] result = new int[k][2];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            double dist1 = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
            double dist2 = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
            return Double.compare(dist2, dist1);
        });

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }


        for (int i = 0; i < k; i++) {
            result[i][0] = maxHeap.peek()[0];
            result[i][1] = maxHeap.poll()[1];
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        System.out.println(kClosest(points, 1));
    }
}
