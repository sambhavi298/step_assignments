import java.util.*;

public class Problem9 {

    static void twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            if (map.containsKey(target - x)) {
                System.out.println("Pair: " + x + "," + (target - x));
            }
            map.put(x, 1);
        }
    }
}
