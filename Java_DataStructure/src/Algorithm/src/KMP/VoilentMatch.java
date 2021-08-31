package Algorithm.src.KMP;

/**
 * @author 万葛亮
 * @Date 2020 08 10 21:48
 * @GIRL friend 江珊
 */
public class VoilentMatch {
    public static void main(String[] args) {
        String str1 = "456454 25644 56566578";
        String str2 = "5665";
        System.out.println(voilentMatch(str1, str2));
    }

    //暴力匹配算法
    public static int voilentMatch(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int s1Len = c1.length;
        int s2Len = c2.length;
        int i = 0, j = 0;
        while (i < s1Len && j < s2Len) {
            if (c1[i]==c2[j]){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if (j==s2Len){
            return i-j;
        }else {
            return -1;
        }
    }
}
