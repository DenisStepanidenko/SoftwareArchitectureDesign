package homeWorks.strategy;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

class AscendingSortingStrategy<T extends Comparable<T>> implements SortingStrategy<T> {
    @Override
    public void sort(List<T> collection) {
        Collections.sort(collection);
    }
}
