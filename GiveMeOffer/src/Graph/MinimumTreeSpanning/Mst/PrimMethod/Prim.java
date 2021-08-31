package Graph.MinimumTreeSpanning.Mst.PrimMethod;

import Graph.MinimumTreeSpanning.Mst.KruskalMethod.CC;
import Graph.MinimumTreeSpanning.Mst.KruskalMethod.WeightedEdges;
import Graph.MinimumTreeSpanning.WeightedGraph;

import java.util.ArrayList;

/**
 * @author Geliang
 * @date 2021-07-14
 * @slogan 致敬大师，致敬未来的你！
 */
public class Prim {
    //  图的顶点
    public int v;
    //  图的边
    public int e;
    //  构建一个图
    public WeightedGraph g;
    //  用来存储结果
    public ArrayList<WeightedEdges> mst;

    //
    public Prim(WeightedGraph graph) {
        this.g = graph;
        v = graph.v;
        e = graph.e;
        mst = new ArrayList<>();
        CC cc = new CC(graph);
        if (cc.ccount > 1) return;// 不止一个联通分量
//      用来记录邻接边
        boolean[] vis = new boolean[v];
//      先把横切边置为true
        vis[0] = true;
//      只用遍历n-1次
        for (int i = 1; i < v; i++) {
//          从该点出发，遍历所有的邻接项目
            WeightedEdges minEdge = new WeightedEdges(-1, -1, Integer.MAX_VALUE);
//          从所有节点出发，
            for (int j = 0; j < v; j++) {
//              从所有的节点出发，已经访问过的节点开始寻找
//              所有的临边
//              如果当前节点被访问过了，那么就遍历他的临边开始找没有被访问过的横切边
                if (vis[j]) {
                    for (int w : g.adj[j].keySet()) {
//                      找到所有的横切边的最短边
                        if (!vis[w] && g.adj[j].get(w) < minEdge.weight) {
//                          更新最短边
                            minEdge = new WeightedEdges(j, w, g.adj[j].get(w));
                        }
                    }
                }
            }
            mst.add(minEdge);
//          把最最短的横切边置为已经被访问过，进行下一次遍历
            vis[minEdge.w] = true;
            vis[minEdge.v] = true;
        }
    }

    public static void main(String[] args) {

        WeightedGraph g = new WeightedGraph("D:\\develop_files\\Idea_Project_files\\myproject\\My_leetcode\\GiveMeOffer\\src\\Graph\\MinimumTreeSpanning\\g.txt");
        Prim prim = new Prim(g);
        System.out.println(prim.mst);
    }
}
