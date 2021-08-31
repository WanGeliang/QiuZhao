package Graph.BFSGraphApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
// 使用BFS 求最短路径
// Unweighted Single Source Shortest Path
public class USSSPath {

    private Graph G;
    private int s;

    private boolean[] visited;
    private int[] pre;
    private int[] dis;

    public USSSPath(Graph G, int s){

        this.G = G;
        this.s = s;

        visited = new boolean[G.V()];
        pre = new int[G.V()];
        dis = new int[G.V()];
        for(int i = 0; i < G.V(); i ++) {
            pre[i] = -1;
            dis[i] = -1;
        }
        bfs(s);

        for(int i = 0; i < G.V(); i ++)
            System.out.print(dis[i] + " ");
        System.out.println();
    }

    private void bfs(int s){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        pre[s] = s;
        dis[s] = 0;// 设定0
        while(!queue.isEmpty()){
            int v = queue.remove();

            for(int w: G.adj(v))
                if(!visited[w]){
                    queue.add(w);
                    visited[w] = true;
//                  记录它的前一个节点
                    pre[w] = v;
//                  从上一个节点来的，求的无权图的最短路径
                    dis[w] = dis[v] + 1;
                }
        }
    }

    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return visited[t];
    }

    public int dis(int t){
        G.validateVertex(t);
        return dis[t];
    }

    public Iterable<Integer> path(int t){

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(!isConnectedTo(t)) return res;

        int cur = t;
        while(cur != s){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){

        Graph g = new Graph("D:\\develop_files\\Idea_Project_files\\myproject\\My_leetcode\\GiveMeOffer\\g.txt");
        USSSPath ussspath = new USSSPath(g, 0);
        System.out.println("0 -> 6 : " + ussspath.path(6));
        System.out.println("0 -> 6 : " + ussspath.dis(6));
    }
}
