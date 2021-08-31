package Test;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
//        Arrays.sort();
        Collections.sort(new ArrayList(), new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
//        Map<Character>
        String s;
//        s.substring()
    }
}
