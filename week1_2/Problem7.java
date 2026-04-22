import java.util.*;

public class Problem7 {
    HashMap<String, Integer> freq = new HashMap<>();

    void add(String query) {
        freq.put(query, freq.getOrDefault(query, 0) + 1);
    }

    List<String> search(String prefix) {
        List<String> res = new ArrayList<>();

        for (String q : freq.keySet()) {
            if (q.startsWith(prefix)) res.add(q);
        }

        res.sort((a, b) -> freq.get(b) - freq.get(a));
        return res.size() > 10 ? res.subList(0, 10) : res;
    }
}
