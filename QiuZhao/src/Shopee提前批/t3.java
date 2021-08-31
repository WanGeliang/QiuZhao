package Shopee提前批;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Geliang
 * @date 2021-07-19
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    public static void main(String[] args) {
        t3 me = new t3();
        System.out.println(me.find("abcd", "bc"));
    }

    public String findMinOverrideSubString(String source, String target) {
        // write code here
        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            ht.put(target.charAt(i), ht.getOrDefault(target.charAt(i), 0) + 1);
        }
        String ans = "";
        int len = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0, j = 0; i < source.length(); i++) {
            hs.put(source.charAt(i), hs.getOrDefault(source.charAt(i), 0) + 1);
            if (ht.containsKey(source.charAt(i)) && hs.get(source.charAt(i)) <= ht.get(source.charAt(i))) {
                cnt++;
            }
            while (j < i && (!ht.containsKey(source.charAt(j)) || hs.get(source.charAt(j)) > ht.get(source.charAt(j)))) {
                int count = hs.get(source.charAt(j)) - 1;
                hs.put(source.charAt(j), count);
                j++;
            }
            if (cnt == target.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = source.substring(j, i + 1);
            }
        }
        return ans;
    }

    public String find(String source, String target) {
        int sLen = source.length(), tLen = target.length();
        int[] hash = new int[128];
        for (char ch : target.toCharArray()) {
            hash[ch]--;
        }
        String ans = "";
        for (int left = 0, right = 0, cnt = 0; right < sLen; right++) {
            if ((++hash[source.charAt(right)]) <= 0) {
                cnt++;
            }
            while (cnt == tLen && hash[source.charAt(left)] > 0) {
                hash[source.charAt(left++)]--;
            }
            if (cnt == tLen) {
                if (ans.equals("") || ans.length() > right - left + 1) {
                    ans = source.substring(left, right + 1);
                }
            }
        }
        return ans;
    }
}
