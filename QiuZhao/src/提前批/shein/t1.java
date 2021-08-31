package 提前批.shein;

/**
 * @author Geliang
 * @date 2021-07-14
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) {
        String s="a b   c";
        System.out.println(replace(s));
    }
    public static String replace(String str){
        if(str==null||str.length()==0) return str;
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if(c[i]==' '){
                sb.append("%20");
            }else{
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
}
