package interview.metapblms;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

    public int largestIsland(int[][] grid) {

        int maxArea = 1;


        int fillUpValue = -1;

        Map<Integer, Integer> map = new HashMap<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int max = dfs(i, j, m, n, fillUpValue, grid);
                    maxArea=Math.max(maxArea,max);
                    map.put(fillUpValue, max);
                    --fillUpValue;
                }
            }

        }


        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();

                if (grid[i][j] == 0) {
                    int currMax = 1;
                    for (int[] dir : directions) {

                        int newRow = i + dir[0];
                        int newCol = j + dir[1];

                        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 0) {
                            continue;
                        }

                        int maxAreaSubIsland = map.get(grid[newRow][newCol]);

                        if (!set.contains(grid[newRow][newCol])) {
                            currMax += maxAreaSubIsland;
                            set.add(grid[newRow][newCol]);
                        }

                        maxArea = Math.max(currMax, maxArea);

                    }
                }

            }
        }


        return maxArea;

    }

    private int dfs(int row, int col, int m, int n, int fillUpValue, int[][] grid) {

        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = fillUpValue;
        int up = dfs(row - 1, col, m, n, fillUpValue, grid);
        int down = dfs(row + 1, col, m, n, fillUpValue, grid);
        int left = dfs(row, col - 1, m, n, fillUpValue, grid);
        int right = dfs(row, col + 1, m, n, fillUpValue, grid);

        return 1 + up + down + left + right;
    }


    @Test
    public void test() {
        int[][] grid = {{1, 1}, {1, 0}};
        System.out.println(largestIsland(grid));
    }
}
