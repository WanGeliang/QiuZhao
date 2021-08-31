package Graph.MinimumTreeSpanning.Mst.KruskalMethod;

import Graph.MinimumTreeSpanning.WeightedGraph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Geliang
 * @date 2021-07-13
 * @slogan 致敬大师，致敬未来的你！
 */
public class Kruskal {
    public ArrayList<WeightedEdges> res;
    public WeightedGraph g;

    public Kruskal(WeightedGraph g) {
        this.g = g;
//      判断该图是否是一整个联通图，如果不是，则直接返回
        CC cc = new CC(g);
//      联通分量的个数大于1
        if (cc.ccount > 1) return;//因为在这个图中，不止一个联通图
//      将所有的边都加入到mst中
        res = new ArrayList<>();
        ArrayList<WeightedEdges> mst = new ArrayList();
        for (int i = 0; i < g.v; i++) {
            for (int v : g.adj[i].keySet()) {
//              不重复加入边到图中
                // 因为我们这个是无权图，所以只需要加入一条边即可
                // 因为双边是
                if (i < v) {
                    mst.add(new WeightedEdges(i, v, g.adj[i].get(v)));
                }
            }
        }
//      将所有的边进行排序
//      找到最短的边，然后进行计算
        Collections.sort(mst, ((o1, o2) -> o1.weight - o2.weight));
//      必须要手写并查集
        UnionFind uf = new UnionFind(g.v);
        for (WeightedEdges edges : mst) {
            int v = edges.v;
            int w = edges.w;
//          判断是否有环，就判断并查集中有没有看之前没有到达过的
            if (!uf.isConnected(v, w)) {
                res.add(edges);
                uf.join(w, v);
            }
        }
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph("D:\\develop_files\\Idea_Project_files\\myproject\\My_leetcode\\GiveMeOffer\\src\\Graph\\MinimumTreeSpanning\\g.txt");
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(kruskal.res);
    }
}
