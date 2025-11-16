package N_bst.B_application;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.SequencedSet;
import java.util.SortedMap;
import java.util.TreeMap;

// Given a filename and an optional Comparator, builds a concordance:
// a list of every distinct word in the file, each word along with
// a list of locations in the file where the word appears. The words
// are listed in their natural order, unless a Comparator has been
// provided.
public class Concordance {
    private final SortedMap<String, SequencedSet<Location>> map;

    public Concordance(String filename) throws FileNotFoundException {
        this(filename, Comparator.naturalOrder());
    }

    public Concordance(String filename, Comparator<String> comparator) throws FileNotFoundException {
        map = new TreeMap<>(comparator);
        buildMap(filename);
    }

    private void buildMap(String filename) throws FileNotFoundException {
        WordLocationGenerator generator = new WordLocationGenerator(filename);

        for (WordLocation wordLocation : generator) {
            String word = wordLocation.word();

            if (!map.containsKey(word)) {
                map.put(word, new LinkedHashSet<>());
            }

            map.get(word).add(wordLocation.location());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (var entry : map.entrySet()) {
            String word = entry.getKey();
            SequencedSet<Location> locations = entry.getValue();

            sb.append(word).append(": ");

            for (Iterator<Location> iterator = locations.iterator(); iterator.hasNext(); ) {
                Location location = iterator.next();
                sb.append(location);

                if (iterator.hasNext()) {
                    sb.append(", ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}