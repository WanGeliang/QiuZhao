package Algorithm.src.Greedy;

import com.sun.xml.internal.ws.encoding.HasEncoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 万葛亮
 * @Date 2020 08 14 15:36
 * @GIRL friend 江珊
 */

//貪心算法
public class greedyAlgorithm {
    public static void main(String[] args) {

        HashMap<String, HashSet<String>> Allmap = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashSet<String> hashSet4 = new HashSet<>();
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        hashSet4.add("上海");
        hashSet4.add("天津");

        hashSet5.add("杭州");
        hashSet5.add("大连");

        Allmap.put("K1", hashSet1);
        Allmap.put("K2", hashSet2);
        Allmap.put("K3", hashSet3);
        Allmap.put("K4", hashSet4);
        Allmap.put("K5", hashSet5);

        HashSet<String> allAreasSet = new HashSet<>();
        allAreasSet.add("北京");
        allAreasSet.add("上海");
        allAreasSet.add("天津");
        allAreasSet.add("广州");
        allAreasSet.add("深圳");
        allAreasSet.add("成都");
        allAreasSet.add("杭州");
        allAreasSet.add("大连");

        HashSet<String> tempSet = new HashSet<>();
        ArrayList<String> resList = new ArrayList<>();
        String maxKey = null;

        while (allAreasSet.size() != 0) {
            //maxKey指控
            maxKey = null;
            for (String key : Allmap.keySet()) {
                tempSet.clear();//tempset置空
                HashSet<String> areas = Allmap.get(key);
                tempSet.addAll(areas);
//                tempSet=Allmap.get(key);
                tempSet.retainAll(allAreasSet);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > Allmap.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                resList.add(maxKey);
                allAreasSet.removeAll(Allmap.get(maxKey));
            }
        }

        System.out.println(resList);
    }
}
