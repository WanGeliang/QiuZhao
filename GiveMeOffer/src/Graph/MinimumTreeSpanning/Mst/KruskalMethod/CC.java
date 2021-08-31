package Graph.MinimumTreeSpanning.Mst.KruskalMethod;

import Graph.MinimumTreeSpanning.WeightedGraph;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-07-14
 * @slogan 致敬大师，致敬未来的你！
 */
// 判断一个图是否是联通图
public class CC {
    public WeightedGraph g;
    public int ccount=0;
    int v;
    int e;
    public int vis[];
    public CC(WeightedGraph g){
        this.g=g;
        this.v=g.v;
        this.e=g.e;
        vis=new int[v];
        Arrays.fill(vis,-1);
//      使用ccount来计算值
        for (int i = 0; i < v; i++) {
            if(vis[i]==-1){
                dfs(i,ccount);
                ccount++;
            }
        }
    }
    public void dfs(int v,int ccid){
        vis[v]=ccid;
        for(int w:g.adj[v].keySet()){
            if(vis[w]==-1){
                dfs(w,ccid);
            }
        }
    }

}
