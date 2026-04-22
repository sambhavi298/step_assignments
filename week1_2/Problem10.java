import java.util.*;

public class Problem10 {

    LinkedHashMap<String, String> L1 = new LinkedHashMap<>(10000, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry e) {
            return size() > 10000;
        }
    };

    HashMap<String, String> L2 = new HashMap<>();

    String get(String key) {
        if (L1.containsKey(key)) return "L1 HIT";

        if (L2.containsKey(key)) {
            L1.put(key, L2.get(key));
            return "L2 HIT";
        }

        String data = "DB_DATA";
        L2.put(key, data);
        return "DB HIT";
    }
}
