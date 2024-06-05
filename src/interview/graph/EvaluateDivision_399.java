package interview.graph;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class EvaluateDivision_399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] result = new double[queries.size()];

        Map<String, List<Pair<String, Double>>> adjacencyList = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            if (!adjacencyList.containsKey(equations.get(i).get(0))) {
                adjacencyList.put(equations.get(i).get(0), new ArrayList<>());
            }

            if (!adjacencyList.containsKey(equations.get(i).get(1))) {
                adjacencyList.put(equations.get(i).get(1), new ArrayList<>());
            }

            adjacencyList.get(equations.get(i).get(0)).add(new Pair<>(equations.get(i).get(1), values[i]));
            adjacencyList.get(equations.get(i).get(1)).add(new Pair<>(equations.get(i).get(0), (double) 1 / values[i]));

        }

        for (int i = 0; i < queries.size(); i++) {
            result[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adjacencyList);
        }

        return result;
    }

    private double bfs(String src, String dst, Map<String, List<Pair<String, Double>>> adjacencyList) {

        if (!adjacencyList.containsKey(src) || !adjacencyList.containsKey(dst)) {
            return -1;
        }

        Queue<Pair<String, Double>> queue = new LinkedList<>();
        queue.add(new Pair(src, (double) 1));

        Set<String> visited = new HashSet<>();
        visited.add(src);

        while (!queue.isEmpty()) {
            Pair<String, Double> polled = queue.poll();
            if (polled.getKey().equals(dst)) {
                return polled.getValue();
            }
            for (Pair<String, Double> pair : adjacencyList.getOrDefault(polled.getKey(),new ArrayList<>())) {
                if (!visited.contains(pair.getKey())) {
                    queue.add(new Pair<>(pair.getKey(),  pair.getValue() * polled.getValue()));
                    visited.add(pair.getKey());
                }
            }

        }
        return -1;
    }

    @Test
    public void test() {
        //[["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "b"));
        equations.add(List.of("b", "c"));
        double[] values = new double[equations.size()];
        values[0] = 2.0;
        values[1] = 3.0;
        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a", "c"));
        queries.add(List.of("b", "a"));
        queries.add(List.of("a", "e"));
        queries.add(List.of("a", "a"));
        queries.add(List.of("x", "x"));

        calcEquation(equations, values, queries);

    }
}
