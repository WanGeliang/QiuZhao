package Graph.MinimumTreeSpanning;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Geliang
 * @date 2021-07-13
 * @slogan 致敬大师，致敬未来的你！
 */
//赞时支持无向的带权图
public class WeightedGraph {
    //  定义顶点,定义边
    public int v;
    public int e;
    public int weight;
    //  使用TreeMap来构建图
    public TreeMap<Integer, Integer>[] adj;

    public WeightedGraph(String filename) {
        File file = new File(filename);
        try (Scanner sc = new Scanner(file)) {

            v = sc.nextInt();
            adj = new TreeMap[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new TreeMap<Integer, Integer>();
            }
            //根据图来构建边
            e = sc.nextInt();
            for (int i = 0; i < e; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                weight = sc.nextInt();
                if (a == b || adj[a].containsKey(b)) throw new IllegalArgumentException();
                adj[a].put(b, weight);
                adj[b].put(a, weight);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // 输出最小生成树的表示
        sb.append(String.format("V = %d, E = %d\n", v, e));
        for (int i = 0; i < v; i++) {
            sb.append(String.format("%d : ", i));
            for (Map.Entry<Integer, Integer> entry : adj[i].entrySet())
                sb.append(String.format("(%d: %d) ", entry.getKey(), entry.getValue()));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph("D:\\develop_files\\Idea_Project_files\\myproject\\My_leetcode\\GiveMeOffer\\src\\Graph\\MinimumTreeSpanning\\g.txt");
        System.out.println(graph);
    }
}
