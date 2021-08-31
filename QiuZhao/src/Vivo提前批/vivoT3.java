package Vivo提前批;

import java.util.*;

/**
 * @author Geliang
 * @date 2021-07-18
 * @slogan 致敬大师，致敬未来的你！
 */
public class vivoT3 {

    //    2,3,4;5;5,6;0;6;0
    public static TreeSet<Integer>[] adj;
    //  记录入度
    public static int[] indegrees;

    public static int timeInt[];

    public static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] time = str.split(",");
        // 节点个数
        int size = time.length;

        adj = new TreeSet[size];
        indegrees = new int[size];

//      每个节点的时间花费的时间
        timeInt = new int[size];
        for (int i = 0; i < size; i++) {
            timeInt[i] = Integer.parseInt(time[i]);
        }

        str = sc.nextLine();

        String[] node = str.split(";");


//      开始构建图
        for (int i = 0; i < node.length; i++) {
            adj[i] = new TreeSet<Integer>();
            String[] tempNum = node[i].split(",");
            for (int j = 0; j < tempNum.length; j++) {
                int num = Integer.parseInt(tempNum[j]) - 1;
                if (num >= 0) {
                    adj[i].add(num);
//                  num-1的入度加1
                    indegrees[num]++;
                }
            }
        }

//        for (int i = 0; i < adj.length; i++) {
//            System.out.println((adj[i]));
//        }
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < size; v++) {
            sb.append(String.format("%d : ", v));
            for (int w : adj[v])
                sb.append(String.format("%d ", w));
            sb.append('\n');
        }
        System.out.println(sb.toString());

//        for (int i = 0; i < size; i++) {
//            System.out.println("第" + (i + 1) + "的入度为：" + indegrees[i]);
//        }

//        System.out.println(Arrays.toString(indegrees));
//        System.out.println(Arrays.toString(timeInt));

        ArrayList<Integer> list = new ArrayList<>();
        queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (indegrees[i] == 0) queue.add(0);
        }
        int res = 0;
        int temp = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            list.add(v);
            for (int w : adj[v]) {
                indegrees[w]--;
                if (indegrees[w] == 0) {
                    queue.add(w);
                }
            }

            temp = Math.max(temp, timeInt[v]);
            res = temp;
        }
//        System.out.println(res);
//        System.out.println(Arrays.toString(list.toArray()));
    }
}


