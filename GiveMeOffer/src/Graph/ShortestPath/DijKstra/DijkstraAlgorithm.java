package Graph.ShortestPath.DijKstra;

import Graph.ShortestPath.WeightedGraph;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-07-15
 * @slogan 致敬大师，致敬未来的你！
 */
public class DijkstraAlgorithm {
    //  用来记录有没有被访问过
    public boolean[] vis;
    //  用来记录从原点开始到的最短路径
    public int[] dis;
    public int s;
    public WeightedGraph graph;

    public DijkstraAlgorithm(WeightedGraph graph, int s) {
        this.graph = graph;
        this.s = s;
        vis = new boolean[graph.v];
        dis = new int[graph.v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        while (true) {
            int cur = -1, curDis = Integer.MAX_VALUE;
//          第1步：找到当前没有访问的最短路节点
            for (int v = 0; v < graph.v; v++) {
                if (!vis[v] && dis[v] < curDis) {
                    cur = v;
                    curDis = dis[v];
                }
            }
            // 没有找到当前节点，就直接退出循环
            if (cur == -1) break;
//          第2步：确认这个节点的最短路径就是当前节点
            vis[cur] = true;
//          第3步：根据这个节点的最短路大小，更新其他节点的路径长度
            for (int w : graph.adj[cur].keySet()) {
                if (!vis[w]) {
                    if (dis[cur] + graph.adj[cur].get(w) < dis[w]) {
                        dis[w] = dis[cur] + graph.adj[cur].get(w);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph("D:\\develop_files\\Idea_Project_files\\myproject\\My_leetcode\\GiveMeOffer\\src\\Graph\\ShortestPath\\g.txt");
        DijkstraAlgorithm dijKstra = new DijkstraAlgorithm(graph, 0);
        System.out.println(Arrays.toString(dijKstra.dis));
    }
}
