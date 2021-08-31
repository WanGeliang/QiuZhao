package 美团正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Geliang
 * @date 2021-08-08
 * @slogan 致敬大师，致敬未来的你！
 */
public class t11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int ZxCount = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ZxCount; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] num = new int[n];
            s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                num[j] = Integer.parseInt(s[j]);
            }
            Arrays.sort(num);
            if (num[0] >= 1 && num[num.length - 1] <= n && k < n) {
                PriorityQueue<Integer> queue = new PriorityQueue<>(k, ((o1, o2) -> o2 - o1));
                for (int j = 0; j < k; j++) {
                    queue.add(num[j]);
                }
//                for (int j = 0; j < queue.size(); j++) {
//                    System.out.println(queue.poll());
//                }
                if (!queue.isEmpty() && queue.peek() == num[k]) {
                    list.add("NO");
                } else {
                    if((queue.peek() + 1)<=n){
                        list.add("YES");
                        list.add(String.valueOf((queue.peek() + 1)));
                    }else {
                        list.add("NO");
                    }
                }
            } else {
                list.add("NO");
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static int getRightMid(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
