package Algorithm.src.KMP;

import java.util.Arrays;

/**
 * @author 万葛亮
 * @Date 2020 08 10 22:56
 * @GIRL friend 江珊
 */
public class KmpAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDA ABCDABCDABDE";
        String str2 = "ABCDAB";
//        String str2 = "BBC";
        int[] ints = kmpNext(str2);
        System.out.println(kmpSearch(str1, str2, ints));
//        System.out.println(Arrays.toString(ints));
    }

    /**
     * @param str1
     * @param str2
     * @param next
     * @return
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str2.charAt(j) == str1.charAt(i)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            //这时kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {//while循环
                j = next[j - 1];
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
//            }else{
//                j=0;
//            }
            next[i] = j;
        }
        return next;
    }
}
