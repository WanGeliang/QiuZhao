package Soul0826;

/**
 * @author Geliang
 * @date 2021-08-26
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {

    public static void main(String[] args) {

    }
    public static String[] MissingBrackets(String[] brackets){
            int n = brackets.length;
            int count = 0;
            for(int i = 0; i < n; i++) //统计左括号数
                if(brackets[i] == "(")
                    count++;
            if(n % 2==1 || count * 2 > n) //不为偶数一定不合法，左括号数大于一般肯定不合法
                return new String[]{"Impossible"};
            int rest = n / 2 - count; //还需要补充多少左括号
            for(int i = 0; i < n; i++){
                if(brackets[i] == "?" && rest != 0){
                    brackets[i] = "(";
                    rest--;
                }
                else if(brackets[i] == "?")
                    brackets[i] = ")";
            }
            int all = 0;
            for(int i = 0; i < n; i++){ //检查修改后内容是否合法
                if(brackets[i]  == "(")
                    all++;
                else if(brackets[i] == ")")
                    all--;
                if(all < 0)
                    return new String[]{"Impossible"};
            }
            return brackets;
        }
    }

