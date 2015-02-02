package no.scienta.lambada.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class ConcurrentStringCache {

    private final ConcurrentMap<Integer, String> cache = new ConcurrentHashMap<>();

    public String get(Integer key) {
        return cache.computeIfAbsent(key, this::create);
    }

    private String create(Integer key) {
        return key.toString();
    }
}
