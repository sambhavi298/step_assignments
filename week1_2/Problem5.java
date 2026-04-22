import java.util.*;

public class Problem5 {
    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueUsers = new HashMap<>();
    HashMap<String, Integer> sources = new HashMap<>();

    void process(String url, String user, String source) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueUsers.putIfAbsent(url, new HashSet<>());
        uniqueUsers.get(url).add(user);

        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }
}
