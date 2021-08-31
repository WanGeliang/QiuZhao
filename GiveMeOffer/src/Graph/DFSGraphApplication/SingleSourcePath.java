package Graph.DFSGraphApplication;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Geliang
 * @date 2021-07-04
 * @slogan 致敬大师，致敬未来的你！
 */
// 应用：单源路径问题
public class SingleSourcePath {

    private Graph G;
    private int s;

    private int[] pre;

    public SingleSourcePath(Graph G, int s){

        this.G = G;
        this.s = s;
        pre = new int[G.V()];
        for(int i = 0; i < pre.length; i ++)
            pre[i] = -1;

//      从指定节点开始进行遍历，从0开始遍历
        dfs(s, s);
    }

    private void dfs(int v, int parent){
//        记录的他前一个节点是什么
        pre[v] = parent;
        for(int w: G.adj(v))
            if(pre[w] == -1)
                dfs(w, v);
    }

    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return pre[t] != -1;
    }

    public Iterable<Integer> path(int t){

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(!isConnectedTo(t)) return res;

//      倒着进行遍历，t
        int cur = t;
        while(cur != s){
            res.add(cur);
            cur = pre[cur];
        }
//      加上源节点
        res.add(s);
//      然后进行反转，最终的结果0->target
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){

        Graph g = new Graph("g.txt");
        SingleSourcePath sspath = new SingleSourcePath(g, 0);
        System.out.println("0 -> 6 : " + sspath.path(6));
        System.out.println("0 -> 5 : " + sspath.path(5));
    }
}
