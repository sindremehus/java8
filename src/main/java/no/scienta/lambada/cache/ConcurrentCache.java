package no.scienta.lambada.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class ConcurrentCache<K, V> {

    private final ConcurrentMap<K, V> cache = new ConcurrentHashMap<>();
    private final Function<K, V> creator;

    public ConcurrentCache(Function<K, V> creator) {
        this.creator = creator;
    }

    public V get(K key) {
        return cache.computeIfAbsent(key, creator);
    }
}
