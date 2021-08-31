package CommonTest;

/**
 * @author Geliang
 * @date 2021-07-31
 * @slogan 致敬大师，致敬未来的你！
 */
public class sb {
    public static void main(String[] args) {
        String s = "I am a boy";
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
