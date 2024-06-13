package interview.metapblms;

import java.util.ArrayList;
import java.util.List;

public class GridPaths {
    public static List<String> findPaths(int m, int n) {
        List<String> paths = new ArrayList<>();
        backtrack(0, 0, m, n, "", paths);
        return paths;
    }

    private static void backtrack(int x, int y, int m, int n, String path, List<String> paths) {
        if (x == m - 1 && y == n - 1) {
            paths.add(path);
            return;
        }
        if (x < m - 1) {
            backtrack(x + 1, y, m, n, path + "D", paths);
        }
        if (y < n - 1) {
            backtrack(x, y + 1, m, n, path + "R", paths);
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        List<String> result = findPaths(m, n);
        System.out.println(result);
    }
}
