package interview.arrays;

import org.junit.Test;

public class ApplyDiscounttoPrices_2288 {


  public String discountPrices(String sentence, int discount) {

    StringBuilder stringBuilder = new StringBuilder();

    String[] split = sentence.split(" ");

    for (String currSplit : split) {
      if (isDollar(currSplit)) {
        stringBuilder.append("$");
        Double number = Double.valueOf(currSplit.substring(1));
        double ans = number - (number * discount / 100.00);
        stringBuilder.append(String.format("%.2f", ans));
      } else {
        stringBuilder.append(currSplit);
      }
      stringBuilder.append(" ");
    }

    return stringBuilder.toString().trim();

  }


  private boolean isDollar(String s) {
    return s.startsWith("$") && s.substring(1).matches("\\d+");
  }

  @Test
  public void tst() {
    //System.out.println(discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
    //System.out.println(discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    System.out.println(discountPrices("ka3caz4837h6ada4 r1 $602", 9));
    System.out.println(discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 28));
  }

}
