package ZuoShen.StackAndQueue;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @author Geliang
 * @date 2021-07-27
 * @slogan 致敬大师，致敬未来的你！
 */
public class getWindowMax {
    public static void main(String[] args) {
//        Hashtable|
//        HashMap
        getWindowMax me = new getWindowMax();
        System.out.println(Arrays.toString(me.getMaxWin(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3)));
    }

    public int[] getMaxWin(int[] arr, int n) {
        int len = arr.length - n + 1;
        int[] res = new int[len];
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 把队尾的元素小于当前值的元素取出来
            while (!list.isEmpty() && arr[list.getLast()] < arr[i]) {
                // 满足条件就移除掉尾元素
                list.removeLast();
            }
            list.add(i);
            // 当头节点的值已经超出了窗口的范围，就移除掉头节点
            if (list.peekFirst() == i - n) {
                list.removeFirst();
            }
            if (i >= n - 1) {
                res[index++] = arr[list.peekFirst()];
            }
        }
        return res;
    }

}
