package warehouse;

import java.util.Comparator;

public class NumberComparator implements Comparator  {

    public int compare(Object o1, Object o2) {
        String  name1 = ((Item) o1).getName();
        String name2 = ((Item) o2).getName();
        if (((Item) o1).getNumber() < ((Item) o2).getNumber()) {
            return 1;
        }
        if (((Item) o1).getNumber() > ((Item) o2).getNumber()) {
            return -1;
        }
        return 0;
    }
}
