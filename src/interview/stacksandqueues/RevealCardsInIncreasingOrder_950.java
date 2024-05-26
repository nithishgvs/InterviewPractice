package interview.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import org.junit.Test;

public class RevealCardsInIncreasingOrder_950 {


  public int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    int[] res = new int[deck.length];
    ArrayDeque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < deck.length; i++) {
      deque.add(i);
    }

    int idx = 0;

    while (!deque.isEmpty()) {
      int index = deque.poll();
      res[index] = deck[idx];
      if (!deque.isEmpty()) {
        deque.add(deque.poll());
      }
      idx++;
    }

    return res;

  }

  @Test
  public void test() {
    int[] deck = {17, 13, 11, 2, 3, 5, 7};
    deckRevealedIncreasing(deck);
  }


}
