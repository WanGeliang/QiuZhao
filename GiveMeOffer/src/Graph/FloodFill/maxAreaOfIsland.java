package Graph.FloodFill;

import java.util.HashSet;

/**
 * @author Geliang
 * @date 2021-07-09
 * @slogan 致敬大师，致敬未来的你！
 */
public class maxAreaOfIsland {
    static int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
    static int R;
    static int C;
    static HashSet<Integer>[] G;
    static boolean[] vis;
    static int[][] grid;

    public static void main(String[] args) {

    }
    public static int maxAreaIsland(int[][] grid){
        if(grid==null) R=grid.length;
        C=grid[0].length;
        vis=new boolean[R*C];
        G=createGraph();
        int res=0;
        for (int i = 0; i < G.length; i++) {
            int x=i/C,y=i%C;
            // 走到这一步，肯定是是构建了一个图的
            if(grid[x][y]==1&&!vis[i]){
                // 每次进入一个图，就需要比较res的值
                res=Math.max(res,dfs(i));
            }
        }
        return res;
    }

    /**
     * 进行深度优先遍历，走到这一步的话，就是构建了一个图
     * @param v
     * @return
     */
    public static int dfs(int v){
        vis[v]=true;
        int res=1;
        for(int w:G[v]){
            if(!vis[w]){
                res+=dfs(w);
            }
        }
        return res;
    }
    /**
     * 自己构建一个图，从二维的映射到一维
     * @return
     */
    public static HashSet<Integer>[] createGraph(){
        HashSet<Integer>[] g=new HashSet[R*C];
        for (int i = 0; i < g.length; i++) {
            g[i]=new HashSet<>();
        }
        for (int i = 0; i < g.length; i++) {
            int x=i/C,y=i%C;
            if(grid[x][y]==1){
                for (int d = 0; d < 4; d++) {
                    int nextx=x+dirs[i][0];
                    int nexty=y+dirs[i][1];
                    if(!inArea(nextx,nexty)&&grid[nextx][nexty]==1){
                        int next=nextx*C+nexty;
                        g[i].add(next);
                        g[next].add(i);
                    }
                }
            }
        }
        return g;
    }
    public static boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
