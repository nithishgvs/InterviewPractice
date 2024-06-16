package interview.metapblms;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return n - 1 <= 0;
        }

        int m = flowerbed.length - 1;

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }

        if (flowerbed[m] == 0 && flowerbed[m - 1] == 0) {
            flowerbed[m] = 1;
            n--;
        }

        for (int i = 1; i < m; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }


        return n <= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 0};
        System.out.println(canPlaceFlowers(nums, 2));
    }
}
