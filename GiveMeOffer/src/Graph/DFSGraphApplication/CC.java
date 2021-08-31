package Graph.DFSGraphApplication;

import java.util.ArrayList;
/**
 * @author Geliang
 * @date 2021-07-04
 * @slogan 致敬大师，致敬未来的你！
 */
// 求联通分量ccount
public class CC {

    private Graph G;
    private int[] visited;
    private int cccount = 0;

    public CC(Graph G){

        this.G = G;
        visited = new int[G.V()];
        for(int i = 0; i < visited.length; i ++)
            visited[i] = -1;

//        必须要将所有的节点开始算起，不然，有其他的联通分量的话，会直接结束遍历
        for(int v = 0; v < G.V(); v ++)
            if(visited[v] == -1){
                dfs(v, cccount);
                // 记录联通分量的个数吧
                cccount ++;
            }
    }

    private void dfs(int v, int ccid){

        // 将vis记录为联通分量的标号
        visited[v] = ccid;
        for(int w: G.adj(v))
            if(visited[w] == -1)
                dfs(w, ccid);
    }

    public int count(){
//        for(int e: visited)
//            System.out.print(e + " ");
//        System.out.println();
        return cccount;
    }

    public boolean isConnected(int v, int w){
        G.validateVertex(v);
        G.validateVertex(w);
        // 使用ccount也就是联通分量来记录vis的访问情况
        return visited[v] == visited[w];
    }

    public ArrayList<Integer>[] components(){

        ArrayList<Integer>[] res = new ArrayList[cccount];
        for(int i = 0; i < cccount; i ++)
            res[i] = new ArrayList<Integer>();

        for(int v = 0; v < G.V(); v ++)
            res[visited[v]].add(v);
        return res;
    }

    public static void main(String[] args){

        Graph g = new Graph("D:\\develop_files\\Idea_Project_files\\myproject\\My_leetcode\\GiveMeOffer\\g.txt");
        CC cc = new CC(g);
        System.out.println(cc.count());

        System.out.println(cc.isConnected(0, 6));
        System.out.println(cc.isConnected(5, 6));

        ArrayList<Integer>[] comp = cc.components();
        for(int ccid = 0; ccid < comp.length; ccid ++){
            System.out.print(ccid + " : ");
            for(int w: comp[ccid])
                System.out.print(w + " ");
            System.out.println();
        }
    }
}
