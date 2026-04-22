import java.util.*;

public class Problem4 {
    HashMap<String, Set<String>> map = new HashMap<>();

    List<String> getNGrams(String text, int n) {
        String[] words = text.split(" ");
        List<String> res = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(words[i + j]).append(" ");
            }
            res.add(sb.toString().trim());
        }
        return res;
    }

    void addDocument(String id, String text) {
        for (String gram : getNGrams(text, 3)) {
            map.putIfAbsent(gram, new HashSet<>());
            map.get(gram).add(id);
        }
    }
}
