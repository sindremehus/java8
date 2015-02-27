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
            words.addAll(IOUtils.readLines(in, "UTF-8"));
        }
    }

    public boolean contains(String word) {
        return words.contains(word);
    }

    public boolean containsStart(String word) {
        String ceiling = words.ceiling(word);
        return ceiling != null && ceiling.startsWith(word);
    }
}
