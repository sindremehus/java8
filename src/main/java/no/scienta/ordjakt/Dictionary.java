package no.scienta.ordjakt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;

/**
 * @author Sindre Mehus
 * @version $Id$
 */
public class Dictionary {

    private final NavigableSet<String> words = new TreeSet<>();

    public Dictionary() throws IOException {
        URL resource = getClass().getResource("/ordliste.txt");
        try (InputStream in = resource.openStream()) {
            words.addAll(IOUtils.readLines(in));
        }
    }

    public boolean contains(String word) {
        return words.contains(word);
    }

    public boolean containsStart(String word) {
        return words.ceiling(word).startsWith(word);
    }
}
