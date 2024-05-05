package interview.stacksandqueues;

import java.util.Stack;

public class OnlineStockSpan_901 {


  class StockSpanner {


    Stack<int[]> stack;

    public StockSpanner() {
      stack = new Stack<>();
    }

    public int next(int price) {
      int span = 1;

      while (!stack.isEmpty() && stack.peek()[0] < price) {
        span += stack.pop()[1];
      }

      stack.add(new int[]{price, span});

      return span;
    }
  }

  public static void main(String[] args) {
    OnlineStockSpan_901 obj = new OnlineStockSpan_901();
    StockSpanner stockSpanner = obj.new StockSpanner();
    stockSpanner.next(100); // return 1
    stockSpanner.next(80);  // return 1
    stockSpanner.next(60);  // return 1
    stockSpanner.next(70);  // return 2
    stockSpanner.next(60);  // return 1
    stockSpanner.next(
        75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
    stockSpanner.next(85);  // return 6
  }

}
