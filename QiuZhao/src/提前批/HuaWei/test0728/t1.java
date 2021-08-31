package 提前批.HuaWei.test0728;

import 提前批.HuaWei.test0728.TopologicalSort.Graph;
import 提前批.HuaWei.test0728.TopologicalSort.TopoSort;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Geliang
 * @date 2021-07-28
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    private Graph G;
    private int n;
    private ArrayList<Integer> res;
    private boolean hasCycle = false;

    public t1(Graph G) {


        this.G = G;

        res = new ArrayList<>();
        // 每天最多吃的药的种类
        this.n = G.N;
        // 入度
        int[] indegrees = new int[G.V()];
        // 出度
        int[] outdegrees = new int[G.V()];
        degree[] gree = new degree[G.V()];
        Queue<Integer> q = new PriorityQueue<>();
//      把所有入度为0的点先加进去
        for (int v = 0; v < G.V(); v++) {
//            indegrees[v] = ;
//            outdegrees[v] = ;
            degree de = new degree(v, G.indegree(v), G.outdegree(v));
//            if (indegrees[v] == 0) q.add(v);

        }

        for (int v = 0; v < G.V(); v++) {

//            if (indegrees[v] == 0) q.add(v);
        }
        while (!q.isEmpty()) {
            int cur = q.remove();
            res.add(cur);

            for (int next : G.adj(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0) q.add(next);
            }
        }

        if (res.size() != G.V()) {
            hasCycle = true;
            res.clear();
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public ArrayList<Integer> result() {
        return res;
    }

    public static void main(String[] args) {

        Graph g = new Graph("ug.txt", true);
        TopoSort topoSort = new TopoSort(g);
        System.out.println(topoSort.result());
    }

}

class degree {
    int v;
    int inDegree;
    int outDegree;

    public degree(int v, int inDegree, int outDegree) {
        this.v = v;
        this.inDegree = inDegree;
        this.outDegree = outDegree;
    }
}