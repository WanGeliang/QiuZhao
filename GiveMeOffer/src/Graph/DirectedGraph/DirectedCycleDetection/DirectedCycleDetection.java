package Graph.DirectedGraph.DirectedCycleDetection;

//有向图的环检测
public class DirectedCycleDetection {

    private Graph G;
    private boolean[] visited;
    private boolean[] onPath;
    private boolean hasCycle = false;

    public DirectedCycleDetection(Graph G){

        if(!G.isDirected())
            throw new IllegalArgumentException("DirectedCycleDetection only works in directed graph.");

        this.G = G;
        visited = new boolean[G.V()];
        onPath = new boolean[G.V()];
        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                if(dfs(v)){
                    hasCycle = true;
                    break;
                }
    }

    // 从顶点 v 开始，判断图中是否有环
    private boolean dfs(int v){

        visited[v] = true;
//      记录当前节点中，被访问过的节点
        onPath[v] = true;
        for(int w: G.adj(v))
            if(!visited[w]){
                if(dfs(w)) return true;
            }
//       如果，此时w已经在被访问过了，那么这个有向图就是有环的
            else if(onPath[w])
                return true;
//      如果，这里没有环，那么就进行回溯到上一个节点，将该访问过的节点去除在该链路中
        onPath[v] = false;
        return false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args){

        Graph g = new Graph("ug.txt", true);
        DirectedCycleDetection cycleDetection = new DirectedCycleDetection(g);
        System.out.println(cycleDetection.hasCycle());

        Graph g2 = new Graph("ug2.txt", true);
        DirectedCycleDetection cycleDetection2 = new DirectedCycleDetection(g2);
        System.out.println(cycleDetection2.hasCycle());
    }
}