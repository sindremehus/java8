package no.scienta.lambada.cache;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ConcurrentCacheTest {

    @Test
    public void testCache() throws Exception {
        ConcurrentCache<URL, Image> imageCache = new ConcurrentCache<>(this::fetchImage);

        URL url = new URL("http://foo.bar");
        assertSame(imageCache.get(url), imageCache.get(url));
    }

    private Image fetchImage(URL url) {
        return new BufferedImage(400, 300, BufferedImage.TYPE_4BYTE_ABGR);
    }
}