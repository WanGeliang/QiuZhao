package 网易0822;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Geliang
 * @date 2021-08-22
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public int minDeletions(String s) {
        // write code here
        int[] count = new int[26];
        int deletion = 0;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = count[i];
            while (freq > 0 && !set.add(freq)) {
                freq--;
                deletion++;
            }
        }
        return deletion;
    }
}
