package 提前批.pdd;

/**
 * @author Geliang
 * @date 2021-06-23
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) {
        int n=3;
        int[][] arr={{1,2,3},{2,1,3},{3,2,1}};
        int res=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res+=arr[i][j];
            }
        }
        System.out.println(res);
    }
}
