package Graph.ShortestPath.DijKstra;

import Graph.ShortestPath.WeightedGraph;

import java.util.*;

/**
 * @author Geliang
 * @date 2021-07-15
 * @slogan 致敬大师，致敬未来的你！
 */
public class DijkstraAlgorithmOptimized {
    public WeightedGraph graph;
    public boolean[] vis;
    public int[] dis;
    public int s;

    public int[] pre;

    private class Node {
        int s, dis;

        public Node(int s, int dis) {
            this.dis = dis;
            this.s = s;
        }
    }

    public DijkstraAlgorithmOptimized(WeightedGraph graph, int s) {
        this.graph = graph;
        this.s = s;
        dis = new int[graph.v];
        vis = new boolean[graph.v];
        pre = new int[graph.v];
        pre[s] = s;
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        int cur = -1;
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.dis - o2.dis));
        queue.add(new Node(s, 0));
        while (!queue.isEmpty()) {
            cur = queue.poll().s;
//          如果该点已经被访问过，则直接进行下一轮
//          因为每一次，可能同一个节点被放了很多次
            if (vis[cur]) continue;
            vis[cur] = true;
            for (int w : graph.adj[cur].keySet()) {
                if (!vis[w]) {
                    if (dis[cur] + graph.adj[cur].get(w) < dis[w]) {
//                      只要更新一条短边，就将其加入到优先级队列中
                        dis[w] = dis[cur] + graph.adj[cur].get(w);
                        queue.add(new Node(w, dis[w]));
//                      求最短路径时，只需要在这里加上前一个节点的信息pre[w] = cur;
                        pre[w] = cur;
                    }
                }
            }
        }

    }

    public List<Integer> getPath(int t) {
        List<Integer> res = new ArrayList<>();
        if (!vis[t]) return res;//判断从s出发是否可达t
        while (t != s) {
            res.add(t);
            t = pre[t];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph("D:\\develop_files\\Idea_Project_files\\myproject\\My_leetcode\\GiveMeOffer\\src\\Graph\\ShortestPath\\g.txt");
        DijkstraAlgorithmOptimized algorithmOptimized = new DijkstraAlgorithmOptimized(graph, 0);
        System.out.println(Arrays.toString(algorithmOptimized.dis));
        System.out.println(algorithmOptimized.getPath(3));
    }
}
