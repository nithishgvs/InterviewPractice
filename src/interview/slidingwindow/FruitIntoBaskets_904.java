package interview.slidingwindow;

import org.junit.Test;

public class FruitIntoBaskets_904 {

  //Longest contiguous array of 2 numbers
  //Each unique number belongs to a particular fruit
  //Each basket can have a particular fruit can't mix 2 diff fruits
  //We are given 2 baskets
  //https://www.youtube.com/watch?v=s_zu2dOkq80


  public int totalFruit(int[] fruits) {

    int max = 0;
    int currentMax = 0;

    int lastFruit = -1;
    int secondLastFruit = -1;
    int lastFruitCount = 0;

    for (int i = 0; i < fruits.length; i++) {

      int currentFruit = fruits[i];

      if (currentFruit == secondLastFruit || currentFruit == lastFruit) {
        currentMax = currentMax + 1;
      } else {
        currentMax = lastFruitCount + 1;
      }

      if (currentFruit == lastFruit) {
        lastFruitCount += 1;
      } else {
        lastFruitCount = 1;
      }

      if (currentFruit != lastFruit) {
        secondLastFruit = lastFruit;
        lastFruit = currentFruit;
      }

      max = Math.max(currentMax, max);
    }

    return max;

  }


  @Test
  public void test() {
    int[] fruits = {0, 1, 2, 2};
    System.out.println(totalFruit(fruits));
  }

}
