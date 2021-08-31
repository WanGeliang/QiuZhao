package Algorithm.src.Dynamic;

/**
 * @author 万葛亮
 * @Date 2020 08 10 17:10
 * @GIRL friend 江珊
 */
//动态规划算法处理背包问题
public class KnapckProblem {
    public static void main(String[] args) {

        int val[] = {1500, 3000, 2000};//每个商品的价值
        int w[] = {1, 4, 3};//每个商品的重量
        int m = 4;//总重量
        int[][] v = new int[w.length + 1][m + 1];
        int[][] p = new int[w.length + 1][m + 1];
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {//从第一个开始比较背包的重量与j值大小的比较
                    v[i][j] = v[i - 1][j];
                } else {//w[i-1]<=j
//                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] >= val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = v[i - 1][j];
                    } else {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        p[i][j] = 1;
                    }
                }
            }

        }
        //遍历
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("*********");
        int x = v.length-1;
        int y = v[0].length-1;
        while (x > 0 && y > 0) {
            if (p[x][y]==1){
                System.out.printf("第 %d 个商品放入包中\n",x);
                y-=w[x-1];
            }
            x--;
        }


    }
}
