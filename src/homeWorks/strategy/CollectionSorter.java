package homeWorks.strategy;

import java.util.List;

public class CollectionSorter<T> {
    private SortingStrategy<T> sortingStrategy;

    public void setSortingStrategy(SortingStrategy<T> sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortCollection(List<T> collection) {
        sortingStrategy.sort(collection);
    }
}
