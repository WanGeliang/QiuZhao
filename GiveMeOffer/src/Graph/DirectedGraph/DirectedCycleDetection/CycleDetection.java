package Graph.DirectedGraph.DirectedCycleDetection;

//无向图的环检测
public class CycleDetection {

    private Graph G;
    private boolean[] visited;
    private boolean hasCycle = false;

    public CycleDetection(Graph G){

        if(G.isDirected())
            throw new IllegalArgumentException("CycleDetection only works in undirected graph.");

        this.G = G;
        visited = new boolean[G.V()];
        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                if(dfs(v, v)){
                    hasCycle = true;
                    break;
                }
    }

    // 从顶点 v 开始，判断图中是否有环
    private boolean dfs(int v, int parent){
        // 将父亲节点设置为已经访问过
        visited[v] = true;
        for(int w: G.adj(v))
            if(!visited[w]){
                if(dfs(w, v)) return true;
            }
//       如果父节点已经被访问过，但是w不是他的上一个节点就是被访问过点
            else if(w != parent)
                return true;
        return false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args){

        Graph g = new Graph("ug.txt", true);
        CycleDetection cycleDetection = new CycleDetection(g);
        System.out.println(cycleDetection.hasCycle());
    }
}