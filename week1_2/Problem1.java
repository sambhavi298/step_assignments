import java.util.*;

public class Problem1 {
    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    List<String> suggest(String username) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            res.add(username + i);
        }
        res.add(username.replace("_", "."));
        return res;
    }

    String mostAttempted() {
        return Collections.max(attempts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
