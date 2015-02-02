package no.scienta.lambada.cache;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URI;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ConcurrentCacheTest {

    @Test
    public void testCache() throws Exception {
        ConcurrentCache<URI, Image> imageCache = new ConcurrentCache<>(this::fetchImage);

        URI uri = new URI("http://foo.bar");
        assertSame(imageCache.get(uri), imageCache.get(uri));
    }

    private Image fetchImage(URI url) {
        // TODO: Fetch image data from URI
        return new BufferedImage(400, 300, BufferedImage.TYPE_4BYTE_ABGR);
    }
}