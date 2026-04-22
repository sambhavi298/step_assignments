import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }
}

public class Problem3 {
    HashMap<String, DNSEntry> cache = new HashMap<>();

    String resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry e = cache.get(domain);
            if (System.currentTimeMillis() < e.expiry) {
                return "HIT: " + e.ip;
            }
        }
        String ip = "1.1.1.1"; // mock
        cache.put(domain, new DNSEntry(ip, 300));
        return "MISS: " + ip;
    }
}
