package 网易0822;

import netscape.security.UserTarget;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-22
 * @slogan 致敬大师，致敬未来的你！
 */
public class t4 {
    public static void main(String[] args) {
//        String s = "azbA5#1@c";
        String s = "g$fed%cba";
        System.out.println(convertMagicalString(s));
//        convertMagicalString(s);
//        System.out.println('b' - 'a');
    }

    public static long convertMagicalString(String magicalString) {
        // write code here
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder resSb = new StringBuilder();
        for (char c : magicalString.toCharArray()) {
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                sb1.append(c);
            }
            if (('0' <= c && c <= '9')) {
                sb2.append(c);
            }
        }
        if (sb1.length() == 0 && sb2.length() == 0) return 0;
        char[] strChar = sb1.toString().toLowerCase().toCharArray();
        char[] strNum = sb2.toString().toCharArray();
        Arrays.sort(strChar);
        Arrays.sort(strNum);
        int i = 0;
        while (i < strChar.length) {
            if (i < strChar.length - 1 && (strChar[i + 1] - strChar[i]) != 1) {
                resSb.append((strChar[i] - 'a' + 1));
                i++;
            } else if (i < strChar.length - 1 && (strChar[i + 1] - strChar[i]) == 1) {
                while (i < strChar.length - 1 && (strChar[i + 1] - strChar[i]) == 1) {
                    i++;
                }
                resSb.append((strChar[i] - 'a' + 1));
                i++;
            } else {
                resSb.append((strChar[i] - 'a' + 1));
                i++;
            }
        }
        int j = 0;
        while (j < strNum.length) {
            resSb.append(((strNum[j] - '0')));
            j++;
        }
        long res = Long.valueOf(resSb.toString());
        return res;
    }
}
