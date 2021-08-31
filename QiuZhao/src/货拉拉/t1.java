package 货拉拉;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) {
        t1 me = new t1();
        System.out.println(me.isValid("youzan", "zyanou"));
    }

    public boolean isValid(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String tempStr = s1 + s1;
        return tempStr.contains(s2);
    }
}
