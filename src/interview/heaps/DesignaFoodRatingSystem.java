package interview.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DesignaFoodRatingSystem {

  class FoodRatings {

    class FoodHelper {

      private String food;
      private Integer rating;

      public FoodHelper(String food, Integer rating) {
        this.food = food;
        this.rating = rating;
      }
    }

    Map<String, SortedSet<FoodHelper>> map = new HashMap<>();

    Map<String, Object[]> foodMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

      for (int i = 0; i < foods.length; i++) {
        String food = foods[i];
        String cuisine = cuisines[i];
        Integer rating = ratings[i];

        SortedSet<FoodHelper> sortedSet = new TreeSet<>((a, b) -> {
          if (a.rating.equals(b.rating)) {
            return a.food.compareTo(b.food);
          }
          return b.rating.compareTo(a.rating);
        });

        if (!map.containsKey(cuisine)) {
          map.put(cuisine, sortedSet);
        }
        map.get(cuisine).add(new FoodHelper(food, rating));
        foodMap.put(food, new Object[]{cuisine, rating});
      }

    }

    public void changeRating(String food, int newRating) {
      Object[] entry = foodMap.get(food);
      String cuisine = (String) entry[0];
      Integer rating = (Integer) entry[1];

      map.get(cuisine).remove(new FoodHelper(food, rating));
      map.get(cuisine).add(new FoodHelper(food, newRating));

      foodMap.remove(food);
      foodMap.put(food, new Object[]{cuisine, newRating});
    }

    public String highestRated(String cuisine) {
      SortedSet<FoodHelper> sortedList = map.get(cuisine);
      return sortedList.isEmpty() ? "" : sortedList.first().food;
    }

  }

  public static void main(String[] args) {

    DesignaFoodRatingSystem foodRatingSystem = new DesignaFoodRatingSystem();
    FoodRatings foodRatings = foodRatingSystem.new FoodRatings(
        new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
        new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
        new int[]{9, 12, 8, 15, 14, 7});
    foodRatings.highestRated("korean"); // return "kimchi"
    // "kimchi" is the highest rated korean food with a rating of 9.
    foodRatings.highestRated("japanese"); // return "ramen"
    // "ramen" is the highest rated japanese food with a rating of 14.
    foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
    foodRatings.highestRated("japanese"); // return "sushi"
    // "sushi" is the highest rated japanese food with a rating of 16.
    foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
    foodRatings.highestRated("japanese"); // return "ramen"

  }

}
