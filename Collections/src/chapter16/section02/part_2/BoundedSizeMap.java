package chapter16.section02.part_2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A refinement of this simple example could take into account the entry supplied as the argument to removeEldestEntry.
 * For example, a directory cache might have a set of reserved names which should never be removed, even if the cache continues to grow as a result.
 */
public class BoundedSizeMap extends LinkedHashMap {

    private int maxEntries;

    public BoundedSizeMap(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxEntries;
    }
}
