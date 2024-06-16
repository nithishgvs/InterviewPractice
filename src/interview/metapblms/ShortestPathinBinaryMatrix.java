package interview.metapblms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int row = polled[0];
            int col = polled[1];
            int dist = polled[2];
            if (row == m - 1 && col == n - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 1) {
                    continue;
                }
                grid[newRow][newCol] = 1;
                queue.add(new int[]{newRow, newCol, dist + 1});
            }
        }

        return -1;
    }


    static class MatrixHelper {
        int row;
        int col;
        List<int[]> path;

        public MatrixHelper(int row, int col, List<int[]> path) {
            this.row = row;
            this.col = col;
            this.path = path;
        }


    }

    public static List<int[]> shortestPathBinaryMatrix2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return new ArrayList<>();
        }

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        Queue<MatrixHelper> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        queue.add(new MatrixHelper(0, 0, list));
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            MatrixHelper polled = queue.poll();
            int row = polled.row;
            int col = polled.col;
            List<int[]> path = polled.path;
            if (row == m - 1 && col == n - 1) {
                return path;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 1) {
                    continue;
                }
                grid[newRow][newCol] = 1;
                List<int[]> currList = new ArrayList<>(path);
                currList.add(new int[]{newRow, newCol});
                queue.add(new MatrixHelper(newRow, newCol, currList));
            }
        }

        return null;
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int[][] grid2 = {{0}};
        System.out.println(shortestPathBinaryMatrix2(grid));
    }

}
