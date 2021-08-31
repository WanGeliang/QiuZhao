package Graph.MinimumTreeSpanning.Mst.KruskalMethod;

/**
 * @author Geliang
 * @date 2021-07-13
 * @slogan 致敬大师，致敬未来的你！
 */
//实现一个并查集
public class UnionFind {
    int size;
    // 并查集的个数
    int[] parent;
    public UnionFind(int size){
        this.size=size;
        parent=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=i;
        }
    }
    // 查找该节点处在哪一个集合中
    public int find(int p){
        while(p!=parent[p]){
            p=parent[parent[p]];
        }
        return p;
    }
    // 是否联通
    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }
    // 合并
    public void join(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot) return;
        parent[pRoot]=qRoot;
    }
}
