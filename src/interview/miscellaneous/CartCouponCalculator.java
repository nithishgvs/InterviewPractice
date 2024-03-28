package interview.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


class CartItem {

  String item;
  Double price;
  Integer quantity;

  public CartItem(String item, Double price, Integer quantity) {
    this.item = item;
    this.price = price;
    this.quantity = quantity;
  }
}

class Coupon {

  Integer discount;

  public Coupon(Integer discount) {
    this.discount = discount;
  }
}

public class CartCouponCalculator {

  public Double calculateCartPrice(List<CartItem> cartItemList, List<Coupon> couponList) {

    Double cartPrice = 0.0;

    PriorityQueue<CartItem> maxHeap1 = new PriorityQueue<>(
        (a, b) -> Double.compare(b.price, a.price));
    PriorityQueue<Coupon> maxHeap2 = new PriorityQueue<>(
        (a, b) -> Double.compare(b.discount, a.discount));

    maxHeap1.addAll(cartItemList);
    maxHeap2.addAll(couponList);

    while (!maxHeap1.isEmpty()) {

      CartItem currentItem = maxHeap1.poll();

      if (!maxHeap2.isEmpty()) {
        Coupon coupon = maxHeap2.poll();
        currentItem.quantity = currentItem.quantity - 1;
        cartPrice += currentItem.price - ((coupon.discount * currentItem.price) / 100);
      }

      cartPrice += currentItem.quantity * currentItem.price;
    }

    return cartPrice;
  }


  public static void main(String[] args) {
    List<CartItem> cartItemList = new ArrayList<>();
    CartItem cartItem1 = new CartItem("book", 20.0, 2);
    CartItem cartItem2 = new CartItem("pens", 10.0, 2);
    cartItemList.add(cartItem1);
    cartItemList.add(cartItem2);
    List<Coupon> couponList = new ArrayList<>();
    Coupon coupon1 = new Coupon(20);
    Coupon coupon2 = new Coupon(30);
    couponList.add(coupon1);
    couponList.add(coupon2);

    CartCouponCalculator cartCouponCalculator = new CartCouponCalculator();
    System.out.println(cartCouponCalculator.calculateCartPrice(cartItemList, couponList));
  }

}
