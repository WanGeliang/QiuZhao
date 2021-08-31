package Shopee提前批.js;

/**
 * @author Geliang
 * @date 2021-08-02
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) {
        String s = "cbc123";
        boolean b = get(s);
        System.out.println(b);
    }

    public static boolean get(String s) {
        if (s == null || s.length() < 2) return false;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                continue;
            } else {
                return false;
            }
        }
        c = s.charAt(0);
        if (!('A' <= c && c <= 'Z')) return false;
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                f1 = true;
            } else if ('a' <= c && c <= 'z') {
                f2 = true;
            } else if ('A' <= c && c <= 'Z') {
                f3 = true;
            }
        }
        return (f1 && f2) || (f1 && f3) || (f2 && f3);
    }
}
