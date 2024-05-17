package homeWorks.strategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        CollectionSorter<Integer> sorter = new CollectionSorter<>();

        // Используем стратегию сортировки по возрастанию
        sorter.setSortingStrategy(new AscendingSortingStrategy<>());
        sorter.sortCollection(numbers);
        System.out.println("Сортировка по возрастанию: " + numbers);

        // Используем стратегию сортировки по убыванию
        sorter.setSortingStrategy(new DescendingSortingStrategy<>());
        sorter.sortCollection(numbers);
        System.out.println("Сортировка по убыванию: " + numbers);
    }
}
