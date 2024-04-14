package interview.backtracking;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner_489 {

  interface Robot {

    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
  }


  class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
      Pair pair = (Pair)obj;
      return this.x == pair.x && this.y == pair.y;
    }

    @Override
    public int hashCode() {
      return this.x * 1000 + this.y;
    }

  }

  private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  private Set<Pair> visitedPositions = new HashSet<>();
  private Robot robot;

  public void cleanRoom(Robot robot) {
    this.robot = robot;
    // Start cleaning from the initial position (0,0)
    backtrack(0, 0, 0);
  }


  // Makes the robot turn around and move back to the previous position
  private void goBack() {
    this.robot.turnRight();
    this.robot.turnRight();
    this.robot.move();
    this.robot.turnRight();
    this.robot.turnRight();
  }


  // Recursive method to clean the room using backtracking
  private void backtrack(int x, int y, int directionIndex) {
    this.visitedPositions.add(new Pair(x, y));
    this.robot.clean();
    // Try all four directions in clockwise order
    for (int i = 0; i < this.DIRECTIONS.length; i++) {
      int newDirectionIndex = (directionIndex + i) % this.DIRECTIONS.length;
      int newX = x + this.DIRECTIONS[newDirectionIndex][0];
      int newY = y + this.DIRECTIONS[newDirectionIndex][1];

      if (!this.visitedPositions.contains(new Pair(newX, newY)) && this.robot.move()) {
        backtrack(newX, newY, newDirectionIndex);
        goBack();
      }
      this.robot.turnRight(); // Always turn the robot to the next direction
    }
  }
}
