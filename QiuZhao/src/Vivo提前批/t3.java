package Vivo提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Geliang
 * @date 2021-06-17
 * @slogan 未来的你！
 */
public class t3 {
    static int number;
    static int[] runTime;
    static int[][] depandancy;

    /**
     * 用例
      3,1,2,5,3,1
      2,3,4;5;5,6;0;6;0
     * 9
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            // 首先处理输入
            String[] runTime_String = str.split(",");
            number = runTime_String.length;
            runTime = new int[number];
            for(int i = 0; i < number; i++){
                runTime[i] = Integer.parseInt(runTime_String[i]);
            }

            str = br.readLine();
            String[] depandancy_String = str.split(";");
            // 使用一个[number][number]存储所有的依赖， 因为节点的下标是从1开始的，所以全部减1让节点的下标从0开始，没有依赖的节点就是-1
            depandancy = new int[number][number];
            for(int i = 0; i < number; i++){
                for(int j = 0; j < number; j++){
                    depandancy[i][j] = -1;
                }
            }
            for(int i = 0; i < number; i++){
                // 还是要有一个string[]接收长的string 各自的依赖
                String[] selfDepandancy_String = depandancy_String[i].split(",");
                // depandancy[i][j] 可以从 selfDepandancy_String 中取出了,不过需要 selfDepandancy_String 的长度
                for(int j = 0, len = selfDepandancy_String.length; j < len; j++){
                    depandancy[i][j] = Integer.parseInt(selfDepandancy_String[j]) - 1; // 所有和节点下标相关的都-1
                }
            }

            // 以上处理完了输出，depandancy[i][]中存储的就是node i所需的依赖
            // runTime[i]就是执行node i所需的时间

            int maxTime = 0;
            for(int i = 0; i <  number; i++){
                int runNodeTime_save = runNodeTime(i, new boolean[number]);
                if(maxTime < runNodeTime_save){
                    maxTime = runNodeTime_save;
                }
            }
            System.out.println(maxTime);
        }
    }

    // runNodeTime表示执行节点i需要多久（包括执行它自己）
    public static int runNodeTime(int nodeIndex, boolean visited[]){
        if(depandancy[nodeIndex][0] == -1){ // -1表示不依赖其它节点
            // 如果访问过了就不在添加了，下面的判断一样
            if(visited[nodeIndex])
                return 0;
            else{
                visited[nodeIndex] = true;
                return runTime[nodeIndex];
            }
        }

        int sumTime = 0;

        // 首先查询它有没有其它的依赖
        for(int i = 0; i < number; i++){
            if(depandancy[nodeIndex][i] != -1){
                sumTime += runNodeTime(depandancy[nodeIndex][i], visited);
            } else {
                break;
            }
        }
        if(visited[nodeIndex])
            return sumTime;
        else{
            visited[nodeIndex] = true;
            return sumTime + runTime[nodeIndex];
        }
    }
}
