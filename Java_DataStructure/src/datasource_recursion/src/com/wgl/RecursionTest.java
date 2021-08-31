package datasource_recursion.src.com.wgl;

/**
 * @author 万葛亮
 * @Date 2020 07 09 23:36
 * @GIRL friend 江珊
 */
//递归
public class RecursionTest {
    public static void main(String[] args) {
        
    }
    //打印问题.
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } //else {
        System.out.println("n=" + n);
        // }
    }
}
