import java.util.*;

public class Problem2 {
    HashMap<String, Integer> stock = new HashMap<>();
    HashMap<String, Queue<Integer>> waiting = new HashMap<>();

    synchronized boolean purchase(String product, int userId) {
        int count = stock.getOrDefault(product, 0);

        if (count > 0) {
            stock.put(product, count - 1);
            return true;
        } else {
            waiting.putIfAbsent(product, new LinkedList<>());
            waiting.get(product).add(userId);
            return false;
        }
    }
}
