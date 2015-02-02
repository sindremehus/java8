package no.scienta.lambada.cache;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class ConcurrentImageCache {

    private final ConcurrentMap<URI, Image> cache = new ConcurrentHashMap<>();

    public Image get(URI uri) {
        return cache.computeIfAbsent(uri, this::create);
    }

    private Image create(URI uri) {
        // TODO: Fetch image data from URI
        return new BufferedImage(400, 300, BufferedImage.TYPE_4BYTE_ABGR);
    }
}
