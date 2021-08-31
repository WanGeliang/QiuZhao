package Graph.MinimumTreeSpanning.Mst.PrimMethod;

import Graph.MinimumTreeSpanning.Mst.KruskalMethod.CC;
import Graph.MinimumTreeSpanning.Mst.KruskalMethod.WeightedEdges;
import Graph.MinimumTreeSpanning.WeightedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * @author Geliang
 * @date 2021-07-14
 * @slogan 致敬大师，致敬未来的你！
 */
// 优化后的prim算法，这里我们使用优先队列来使用
public class ImprovedPrim {
    int v;
    int w;
    WeightedGraph g;
    ArrayList<WeightedEdges> mst;

    public ImprovedPrim(WeightedGraph graph) {
        this.g = graph;
        mst = new ArrayList<>();
        CC cc = new CC(g);
//      看图中是否只有一个联通分量
        if (cc.ccount > 1) return;
        boolean[] vis = new boolean[g.v];
        vis[0] = true;
        Queue<WeightedEdges> queue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
//      将该节点的横切边都加入到优先队列中
        for (int w : g.adj[0].keySet()) {
            queue.add(new WeightedEdges(0, w, g.adj[0].get(w)));
        }
//      使用优先级队列
        while (!queue.isEmpty()) {
            WeightedEdges edges = queue.poll();
//          判断取出来的值，是否已经被访问过，如果是的话，就直接继续
            if (vis[edges.w] && vis[edges.v]) continue;
//          将最短边加入到优先级队列中
            mst.add(edges);
//          观察哪个节点是没有被访问过的
//          看哪个节点还没有被访问过
            int newV = vis[edges.v] ? edges.w : edges.v;
            vis[newV] = true;
            for (int m : g.adj[newV].keySet()) {
                queue.add(new WeightedEdges(newV, m, g.adj[newV].get(m)));
            }
        }
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("D:\\develop_files\\Idea_Project_files\\myproject\\My_leetcode\\GiveMeOffer\\src\\Graph\\MinimumTreeSpanning\\g.txt");
        Prim prim = new Prim(g);
        System.out.println(prim.mst);
    }
}
