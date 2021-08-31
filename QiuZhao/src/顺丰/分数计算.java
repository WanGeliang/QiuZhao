package 顺丰;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class 分数计算 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int[] xiShu = Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][s.length];
            for (int i = 0; i < n; i++) {
                s = br.readLine().split(" ");
                arr[i] = Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
            }
            int maxScore = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int sumScore = 0;
                for (int j = 0; j < s.length; j++) {
                    sumScore += arr[i][j] * xiShu[j];
                }
                map.put((i + 1), sumScore);
                maxScore = Math.max(maxScore, sumScore);
            }
            List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if(o1.getValue()!=o2.getValue()){
                        return o2.getValue()-o1.getValue();
                    }else {
                        return o1.getKey()-o2.getKey();
                    }
                }
            });
            int count=0;
            List<Integer> bianHao=new ArrayList<>();
            for(Map.Entry<Integer,Integer> mapping:list){
                if(mapping.getValue()==maxScore) {
                    count++;
                    bianHao.add(mapping.getKey());
                }
            }
            System.out.println(maxScore);
            System.out.println(count);
            for (int i = 0; i < bianHao.size(); i++) {
                System.out.println(bianHao.get(i));
            }
        }
    }
}
