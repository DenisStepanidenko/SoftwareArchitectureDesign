package homeWorks.first.kiss;

public class StringListOld {
    private final String[] list = new String[10];
    private int count = 0;


    @Override
    public String toString() {
        System.out.println("____");
        System.out.println("from denis");
        System.out.println("from matvey again");
        String output = "";
        for (String s : list) {
            if (s != null) {
                output += s + " ";
            }
        }
        return output;
    }

    public void insert(String s) {
        if (s != null) {
            list[count] = s;
            count++;
        }
    }
}
