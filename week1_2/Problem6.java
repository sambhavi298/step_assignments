import java.util.*;

class TokenBucket {
    int tokens, max;
    long lastRefill;

    TokenBucket(int max) {
        this.max = max;
        this.tokens = max;
        this.lastRefill = System.currentTimeMillis();
    }
}

public class Problem6 {
    HashMap<String, TokenBucket> map = new HashMap<>();

    boolean allow(String client) {
        map.putIfAbsent(client, new TokenBucket(1000));
        TokenBucket tb = map.get(client);

        long now = System.currentTimeMillis();
        if (now - tb.lastRefill > 3600000) {
            tb.tokens = tb.max;
            tb.lastRefill = now;
        }

        if (tb.tokens > 0) {
            tb.tokens--;
            return true;
        }
        return false;
    }
}
