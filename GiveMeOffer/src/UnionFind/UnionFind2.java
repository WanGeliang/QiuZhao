package UnionFind;

/**
 * @author Geliang
 * @date 2021-07-02
 * @slogan 致敬大师，致敬未来的你！
 */
public class UnionFind2 implements UF {
    static int[] parent;

    // 构造器
    public UnionFind2(int size){
        parent=new int[size];

        // 初始化,每个节点指向自己，将自己单独作为一个根节点
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    // 查找当前节点所在的分组，时间复杂度为树的高度O(n)
    public int find(int p){
        while (p!=parent[p]){
            p=parent[p];
        }
        return p;// 根节点
    }
    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    // 合并两个节点，就要修改他的根节点的分组
    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot){// 判断两者是否相同，如果相同则直接返回
            return;
        }
        // 如果不相同，则将p所在的根节点指向q所在根节点的分组
        parent[pRoot]=qRoot;
    }
}
