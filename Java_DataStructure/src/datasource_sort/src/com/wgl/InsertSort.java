package datasource_sort.src.com.wgl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 万葛亮
 * @Date 2020 07 13 20:31
 * @GIRL friend 江珊
 */
public class InsertSort {
    public static void main(String[] args) {
//                int[] arr={-1,-3,5,2,50,9};
//        selectBubble(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
//        System.out.println(Arrays.toString(arr));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = dateFormat.format(date);
        System.out.println("排序前的时间为：" + s1);
        insertSort(arr);
        Date date2 = new Date();
        String s2 = dateFormat.format(date2);
        System.out.println("排序前的时间为：" + s2);//2s
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int Index = i - 1;
            while (Index >= 0 && val < arr[Index]) {
                arr[Index + 1] = arr[Index];
                Index--;
            }
            if (Index != i - 1) {
                arr[Index + 1] = val;
            }
//            System.out.println("第"+i+"次排序：");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
