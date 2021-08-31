package CommonTest;

import java.util.*;


/**
 * @author Geliang
 * @date 2021-06-19
 * @slogan 致敬大师，致敬未来的你！
 */
public class jdk8New {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        // 遍历集合list中的元素
//        list.stream().forEach(x-> System.out.println(x));
        list.stream().forEach(System.out::println);
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,3);
        map.put(4,6);
        map.put(3,5);
//        list.stream().collect(Collectors.toList());
//        System.out.println(list.stream().count());
    }
}
