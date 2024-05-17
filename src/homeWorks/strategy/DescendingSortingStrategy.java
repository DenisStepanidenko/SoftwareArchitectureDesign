package homeWorks.strategy;

import java.util.Collections;
import java.util.List;

class DescendingSortingStrategy<T extends Comparable<T>> implements SortingStrategy<T> {
    @Override
    public void sort(List<T> collection) {
        collection.sort(Collections.reverseOrder());
    }

}
