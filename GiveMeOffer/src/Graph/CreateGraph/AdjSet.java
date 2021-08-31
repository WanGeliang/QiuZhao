package Graph.CreateGraph;

import java.util.*;

/**
 * @author Geliang
 * @date 2021-07-01
 * @slogan 致敬大师，致敬未来的你！
 */
public class AdjSet {

    static int vertex=0;// 多少个点
    static int edge=0;// 多少条边
    static TreeSet<Integer>[] adj;
    // 多少条联通分量
    static int count=0;
    // 是否访问过，这个方式不能查看是否两点之间是否联通
    static boolean[] vis;
    // 使用数组来记录两个每个节点之间是否被访问过
    static int[] visArray;
    // 遍历的顺序
    static List<Integer> list=new ArrayList<>();

    // 记录单源路径的起始点
    static int s;
    // 记录单源路径中的前一个节点
    static int[] pre;
    // 从键盘输入输入数
    Scanner sc=new Scanner(System.in);

    /**
     * 初始化一个adj，创建一个邻接表
     */
    public AdjSet(){

        this.vertex=sc.nextInt();
        this.edge=sc.nextInt();
        // 根据顶点初始化一个Set
        adj=new TreeSet[vertex];
        // 访问vis
        vis=new boolean[vertex];
        // 初始化一个数组记录
        visArray=new int[vertex];
        Arrays.fill(visArray,-1);

        // 初始化一个pre数组来表示前一个节点
        pre=new int[vertex];
        Arrays.fill(pre,-1);
        // 将每一个临界表初始化为一个TreeSet
        for (int i = 0; i < vertex; i++) {
            adj[i]=new TreeSet<>();
        }

        // 然后根据边构建图
        for (int i = 0; i < edge; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            // 如果图中已经有了该顶点，则跳过
            if(adj[a].contains(b)) continue;// 如果在以a为顶点中已经存在b这个顶点了

            adj[a].add(b);
            adj[b].add(a);
        }
    }

    @Override
    public String toString() {
        return "AdjSet{" +
                "vertex=" + vertex +
                ", edge=" + edge +
                ", adj=" + Arrays.toString(adj) +
                '}';
    }

    /**
     * 统计单源路径，从哪个节点开始出发
     * @param v
     * @param parent
     */
    public static void dfsSingle(int v,int parent){
        pre[v]=parent;// 记录一下parent节点
        vis[v]=true;
        for (int w:adj[v]){
            if (!vis[w]){
                dfsSingle(w,v);
            }
        }
    }
    // 判断一下能否到达另外一个节点
    public static boolean isConnectedTo(int t){
        return pre[t]!=-1;
    }

    // 打印单源路径
    public static Iterable<Integer>  getPath(int s,int t){
        List<Integer> tempList=new ArrayList<>();
        if(!isConnectedTo(t)) return tempList;
        // 倒着进行遍历
        while(t!=s){
            tempList.add(t);
            t=pre[t];// 找到他的父节点
        }
        tempList.add(s);
        Collections.reverse(tempList);
        return tempList;
    }

    /**
     * 使用普通的vis数组来求解
     * @param v
     */
    public static void dfs(int v){
        vis[v]=true;
        list.add(v);
        for(int w: adj[v]){
            if(!vis[w]){
                dfs(w);
                count++;
            }
        }
    }

    /**
     * 深度优先遍历
     * @param v；直接将count的值作为数组需要赋值的值
     */
    public static void dfs(int v,int count){
        visArray[v]=count;
        list.add(v);
        for(int w: adj[v]){
            if(visArray[w]==-1){
                dfs(w,count);// 使用count作为两个值是否相通的依据
            }
           }
    }

    /**
     * 判断两个节点是否相连
     * @param x
     * @param y
     * @return
     */
    public static boolean isConnected(int x,int y){
        return visArray[x]==visArray[y];
    }



    public static void main(String[] args) {
//      构建一个图
        AdjSet adjSet = new AdjSet();

        System.out.println(adjSet.toString());

//        for (int i = 0; i < vertex; i++) {
//            // 使用boolean值来表示
////            if(!vis[i]){
////                dfs(i);
////                // 使用count来记录一个联通分量
////                count++;
////            }
//            // 使用int[] 型的来表示
//            if(visArray[i] == -1){
//                dfs(i,count);
//                count++;
//            }
//        }
        // 单源路径问题

        list.forEach(System.out::print);
//        System.out.println("联通分量的个数为："+count);
//        System.out.println("两点是否相通："+isConnected(5,0));
        dfsSingle(0,0);
        getPath(0,6).forEach(System.out::print);

    }
}
