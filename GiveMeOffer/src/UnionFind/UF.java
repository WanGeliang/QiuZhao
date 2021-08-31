package UnionFind;

/**
 * @author Geliang
 * @date 2021-07-02
 * @slogan 致敬大师，致敬未来的你！
 */
public interface UF {
    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
