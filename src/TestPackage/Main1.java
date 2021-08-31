package TestPackage;


import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main1 mainObj = new Main1();
        int len = mainObj.getCommonStrLength(sc.next(),sc.next());
        System.out.println(len);
    }

    int getCommonStrLength(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int len1 = str1.length();
        int len2 = str2.length();
        String min = null;
        String max = null;
        String target = null;
        min = len1 <= len2 ? str1 : str2;
        max = len1 >  len2 ? str1 : str2;
        //最外层：min子串的长度，从最大长度开始
        for (int i = min.length(); i >= 1; i--) {
            //遍历长度为i的min子串，从0开始
            for (int j = 0; j <= min.length() - i; j++) {
                target = min.substring(j, j + i);
                //遍历长度为i的max子串，判断是否与target子串相同，从0开始
                for (int k = 0; k <= max.length() - i; k++) {
                    if (max.substring(k,k + i).equals(target)) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

}
