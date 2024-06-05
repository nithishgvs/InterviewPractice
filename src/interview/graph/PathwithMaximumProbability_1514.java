package interview.graph;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class PathwithMaximumProbability_1514 {


    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<Pair<Integer, Double>>> map = new HashMap<>();


        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            if (!map.containsKey(src))
                map.put(src, new ArrayList<>());
            if (!map.containsKey(dst))
                map.put(dst, new ArrayList<>());
            map.get(src).add(new Pair<>(dst, succProb[i]));
            map.get(dst).add(new Pair<>(src, succProb[i]));
        }


        if (!map.containsKey(start_node) || !map.containsKey(end_node))
            return 0;


        PriorityQueue<Pair<Integer, Double>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        maxHeap.add(new Pair(start_node, (double) 1));

        Set<Integer> visited = new HashSet<>();

        while (!maxHeap.isEmpty()) {
            Pair<Integer, Double> polled = maxHeap.poll();
            if (polled.getKey() == end_node) {
                return polled.getValue();
            }
            if (visited.contains(polled.getKey()))
                continue;
            for (Pair<Integer, Double> adj : map.getOrDefault(polled.getKey(), new ArrayList<>())) {
                maxHeap.add(new Pair(adj.getKey(), adj.getValue() * polled.getValue()));
            }
            visited.add(polled.getKey());
        }
        return 0;
    }

    @Test
    public void test() {
        //n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
        int[][] edges = {{0, 3}, {1, 7}, {1, 2},{0,9}};
        double[] succProb = new double[]{0.31,0.9,0.86,0.36};
        System.out.println(maxProbability(4, edges, succProb, 2, 3));
    }
}
