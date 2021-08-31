package Algorithm.src.Prim;

import java.util.Arrays;

/**
 * @author 万葛亮
 * @Date 2020 08 14 16:37
 * @GIRL friend 江珊
 */
public class primAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        //创建MGraph对象
        Graph graph = new Graph(vertexs);
        //创建mintree
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, vertexs, data, weight);
        minTree.showGraph(graph);
        minTree.primAlgorithm(graph, 1);
    }
}

//创建最小生成树
class MinTree {

    public void createGraph(Graph graph, int vertex, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < vertex; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < vertex; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(Graph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void primAlgorithm(Graph graph, int v) {
        int[] visited = new int[graph.vertexs];//默认初始化为0
        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        for (int k = 1; k < graph.vertexs; k++) {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边
            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for (int i = 0; i < graph.vertexs; i++) {// i结点表示被访问过的结点
                for (int j = 0; j < graph.vertexs; j++) {//j结点表示还没有访问过的结点
                    //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        h1 = i;
                        h2 = j;
                        minWeight = graph.weight[i][j];
                    }
                }
            }
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
            //找到一条边是最小
            System.out.println("图的边为：<" + graph.data[h1] + "," + graph.data[h2] + ">, " + "权重为：" + graph.weight[h1][h2]);
        }
    }
}

//构造图
class Graph {
    int vertexs;
    char[] data;
    int[][] weight;

    public Graph(int vertexs) {
        this.vertexs = vertexs;
        this.data = new char[vertexs];
        this.weight = new int[vertexs][vertexs];
    }
}