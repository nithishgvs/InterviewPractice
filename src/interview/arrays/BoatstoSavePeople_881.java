package interview.arrays;

import java.util.Arrays;
import org.junit.Test;

public class BoatstoSavePeople_881 {


  public int numRescueBoats(int[] people, int limit) {

    int boats = 0;

    Arrays.sort(people);

    int l = 0, h = people.length - 1;

    while (l <= h) {

      if (people[l] + people[h] <= limit) {
        l++;
      }

      h--;
      boats++;

    }
    return boats;
  }

  @Test
  public void test() {
    int[] people = {3, 5, 3, 4};

    System.out.println(numRescueBoats(people, 5));

  }

}
