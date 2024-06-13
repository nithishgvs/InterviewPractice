package interview.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze_490 {

    private static final int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // If we reached the destination
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }

            for (int[] direction : directions) {
                int x = current[0];
                int y = current[1];

                // Roll the ball until it hits a wall
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += direction[0];
                    y += direction[1];
                }

                // Step back to the last valid position
                x -= direction[0];
                y -= direction[1];

                // If this position has not been visited, add it to the queue
                if (!visited[x][y]) {
                    queue.add(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }

        // If we exhaust all possibilities and don't find the destination
        return false;

    }
}
