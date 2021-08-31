package Graph.MinimumTreeSpanning.Mst.KruskalMethod;


/**
 * @author Geliang
 * @date 2021-07-13
 * @slogan 致敬大师，致敬未来的你！
 */
// 存储最小图中的所有边
public class WeightedEdges {
    public int v;
    public int w;
    public int weight;
    public WeightedEdges(int v, int w, int weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return String.format("(%d——%d: %d)",v,w,weight);
    }
}
