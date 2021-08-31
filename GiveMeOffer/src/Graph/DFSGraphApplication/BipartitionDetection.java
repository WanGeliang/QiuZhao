package Graph.DFSGraphApplication;

//二分图检测
//二分图的概念：一条边的两个节点的颜色不同，图中所有的节点和边满足这种情况的时候，这个图就是二分图

public class BipartitionDetection {

    private Graph G;

    private boolean[] visited;
    private int[] colors;
    private boolean isBipartite = true;

    public BipartitionDetection(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        for(int i = 0; i < G.V(); i ++)
            colors[i] = -1;// 使用0和1来表示二分图的颜色

        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                if(!dfs(v, 0)){
                    isBipartite = false;
                    break;
                }
    }

    /**
     * 首先得明白dfs函数的含义
     * @param v
     * @param color
     * @return
     */
    private boolean dfs(int v, int color){

        visited[v] = true;
        colors[v] = color;
        for(int w: G.adj(v))
            if(!visited[w]){
                if(!dfs(w, 1 - color)) return false;
            }
//        如果相邻的颜色相同，则就不是二分图，直接返回false
//        因为是从节点w出发的，同时v是他的相邻节点，如果此时，相邻节点的颜色相同，就代表不是二分图，最终就是返回false
            else if(colors[w] == colors[v])
                return false;
        return true;
    }

    public boolean isBipartite(){
        return isBipartite;
    }

    public static void main(String[] args){

        Graph g = new Graph("g.txt");
        BipartitionDetection bipartitionDetection = new BipartitionDetection(g);
        System.out.println(bipartitionDetection.isBipartite);
        // true

        Graph g2 = new Graph("g2.txt");
        BipartitionDetection bipartitionDetection2 = new BipartitionDetection(g2);
        System.out.println(bipartitionDetection2.isBipartite);
        // false

        Graph g3 = new Graph("g3.txt");
        BipartitionDetection bipartitionDetection3 = new BipartitionDetection(g3);
        System.out.println(bipartitionDetection3.isBipartite);
        // true
    }
}
