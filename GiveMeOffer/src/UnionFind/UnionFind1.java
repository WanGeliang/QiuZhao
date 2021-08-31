package UnionFind;

/**
 * @author Geliang
 * @date 2021-07-02
 * @slogan 致敬大师，致敬未来的你！
 */
public class UnionFind1 implements UF{
    static int[] ids;// 作为并查集
    // 构造器,初始化并查集的大小
    public UnionFind1(int size){
        ids=new int[size];
        // 初始化并查集所在的分组
        for (int i = 0; i < ids.length; i++) {
            ids[i]=i;
        }
    }

    /**
     * 查找并查集所在的分组
     * @param m
     * @return
     */
    public int find(int m){
        return ids[m];
    }
    @Override
    public int getSize() {
        return ids.length;
    }

    // 判断两个点是否在一个集合中
    @Override
    public boolean isConnected(int p, int q) {
        return find(q)==find(p);
    }

    // 将两个元素合并为一个分组
    @Override
    public void unionElements(int p, int q) {
        int qid=find(q);
        int pid=find(p);
        for (int i = 0; i < ids.length; i++) {
            if(ids[i]==qid){
                ids[i]=pid;
            }
        }
    }
}
