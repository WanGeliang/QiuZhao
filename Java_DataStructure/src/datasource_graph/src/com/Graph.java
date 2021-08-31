package datasource_graph.src.com;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author 万葛亮
 * @Date 2020 08 05 17:11
 * @GIRL friend 江珊
 */
public class Graph {
    public static void main(String[] args) {
//        String[] Vertexs = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        Graph graph = new Graph(8);
        for (String s : Vertexs) {
            graph.insertEdges(s);
        }
        //设置权值
//        graph.insertVertex(0, 1, 1);
//        graph.insertVertex(0, 2, 1);
//        graph.insertVertex(2, 1, 1);
//        graph.insertVertex(1, 3, 1);
//        graph.insertVertex(1, 4, 1);


        //更新边的关系
        graph.insertVertex(0, 1, 1);
        graph.insertVertex(0, 2, 1);
        graph.insertVertex(1, 3, 1);
        graph.insertVertex(1, 4, 1);
        graph.insertVertex(3, 7, 1);
        graph.insertVertex(4, 7, 1);
        graph.insertVertex(2, 5, 1);
        graph.insertVertex(2, 6, 1);
        graph.insertVertex(5, 6, 1);

        graph.showGraph();
//        System.out.println(graph.getFirstNeighbor(0));
//        System.out.println(graph.getNextNeighbor(0, 1));
        System.out.println("深度有限遍历：");


        long time1 = new Date().getTime();
        graph.dfs();
        long time2 = new Date().getTime();
        System.out.println();
        System.out.println("广度优先遍历："+(time2-time1));
        long time3 = new Date().getTime();
        graph.bfs();
        long time4 = new Date().getTime();
        System.out.println("广度优先遍历："+(time4-time3));

    }

    private int numsEdges;

    private int[][] edges;

    private List<String> vertexList;

    private boolean isVisited[];

    //初始化构造器
    public Graph(int n) {
        this.numsEdges = 0;
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<>(n);
    }

    //得到第一个邻接结点的下标 w

    /**
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //得到第一个邻接结点的下标 w

    /**
     * @param n1 n2
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getNextNeighbor(int n1, int n2) {
        for (int i = n2 + 1; i < getNumOfVertex(); i++) {
            if (edges[n1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);

        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    private void dfs() {
        isVisited=new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
    //得到第一个邻接结点的下标 w
//    /**
//     *
//     * @param index
//     * @return 如果存在就返回对应的下标，否则返回-1
//     */
//    public int getFirstNeighbor(int index) {
//        for(int j = 0; j < vertexList.size(); j++) {
//            if(edges[index][j] > 0) {
//                return j;
//            }
//        }
//        return -1;
//    }
//    //根据前一个邻接结点的下标来获取下一个邻接结点
//    public int getNextNeighbor(int v1, int v2) {
//        for(int j = v2 + 1; j < vertexList.size(); j++) {
//            if(edges[v1][j] > 0) {
//                return j;
//            }
//        }
//        return -1;
//    }
//
//    //深度优先遍历算法
//    //i 第一次就是 0
//    private void dfs(boolean[] isVisited, int i) {
//        //首先我们访问该结点,输出
//        System.out.print(getValueByIndex(i) + "->");
//        //将结点设置为已经访问
//        isVisited[i] = true;
//        //查找结点i的第一个邻接结点w
//        int w = getFirstNeighbor(i);
//        while(w != -1) {//说明有
//            if(!isVisited[w]) {
//                dfs(isVisited, w);
//            }
//            //如果w结点已经被访问过
//            w = getNextNeighbor(i, w);
//        }
//
//    }
//
//
//    //对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
//    public void dfs() {
//        //遍历所有的结点，进行dfs[回溯]
//        for(int i = 0; i < getNumOfVertex(); i++) {
//            if(!isVisited[i]) {
//                dfs(isVisited, i);
//            }
//        }
//    }

    LinkedList<Integer> queue = new LinkedList<>();

    public void bfs(boolean[] isVisited, int i) {
        queue.addLast(i);
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (!queue.isEmpty()) {
            Integer first = queue.removeFirst();
            w = getFirstNeighbor(first);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                } else {
                    w = getNextNeighbor(first, w);
                }
            }

        }
    }

    public void bfs() {
        isVisited=new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    /**
     * 构建图的矩阵
     *
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertVertex(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numsEdges++;
    }

    /**
     * 插入節點
     *
     * @param edges
     */
    public void insertEdges(String edges) {
        vertexList.add(edges);
    }

    /**
     * 显示权值去矩阵
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 显示边数
     */
    public void showEdges() {
        System.out.println("边数为：" + numsEdges);
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }
}
