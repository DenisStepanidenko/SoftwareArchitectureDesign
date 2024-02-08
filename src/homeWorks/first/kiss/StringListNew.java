package homeWorks.first.kiss;

import java.util.Arrays;

public class StringListNew {
    private final String[] list = new String[10];
    private int count = 0;

    @Override
    public String toString() {
        StringBuilder listView = new StringBuilder();
        Arrays.stream(list).limit(count).forEachOrdered(currentString -> listView.append(currentString).append(","));
        return listView.toString();
    }

    public void insert(String s) {
        if (s != null) {
            list[count] = s;
            count++;
        }
    }
}
