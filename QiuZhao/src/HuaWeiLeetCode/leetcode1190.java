package HuaWeiLeetCode;

/**
 * @author Geliang
 * @date 2021-07-25
 * @slogan 致敬大师，致敬未来的你！
 */
// 反转每对括号间的字串
public class leetcode1190 {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParenTheses(s));
    }

    public static String reverseParenTheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        int j = 0;
        while (true) {
            int end = sb.indexOf(")");
            int pre = sb.lastIndexOf("(", end);
            if (pre == -1 || end == -1) {
                break;
            }
            StringBuilder sbTemp = new StringBuilder(sb.substring(pre + 1, end));
            sbTemp.reverse();
            sb.replace(pre, end + 1, sbTemp.toString());
        }
        return sb.toString();
    }
}
