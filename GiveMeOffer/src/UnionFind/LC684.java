package UnionFind;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-07-03
 * @slogan 致敬大师，致敬未来的你！
 */
// 适用于无向图
public class LC684 implements UF {
    int size = 1005;
    int parent[] = new int[size];
    public static void main(String[] args) {
        LC684 me = new LC684();
        int[][] edges={{1,3},{1,2},{2,3}};
        me.init();
        int[] res={};
        for (int i = 0; i < edges.length; i++) {
            if(me.isConnected(edges[i][0],edges[i][1])){
                res=edges[i];
                break;
            }else {
                me.unionElements(edges[i][0],edges[i][1]);
            }
        }
        System.out.println(Arrays.toString(res));
    }

    public void init(){
        for (int i = 0; i < size; i++) {
            parent[i] = i;// 初始化
        }
    }

    // 查找节点p所在的父节点
    public int find(int p){
        while(p!=parent[p]){
            p=parent[p];
        }
        return p;
    }
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot) return;
        parent[pRoot]=qRoot;
    }
}
