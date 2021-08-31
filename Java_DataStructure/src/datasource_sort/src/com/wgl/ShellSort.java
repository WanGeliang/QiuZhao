package datasource_sort.src.com.wgl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 万葛亮
 * @Date 2020 07 13 21:32
 * @GIRL friend 江珊
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(arr);
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]= (int) (Math.random()*80000);
        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = dateFormat.format(date);
        System.out.println("排序前的时间为：" + s1);
//        shellSort(arr);//12s
                shellInsertSort(arr);//不到1s
        Date date2 = new Date();
        String s2 = dateFormat.format(date2);
        System.out.println("排序前的时间为：" + s2);
    }

    //冒泡+希尔
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int j = gap; j < arr.length; j++) {
                for (int i = j - gap; i >= 0; i -= gap) {
                    if (arr[i] > arr[i + gap]) {
                        temp = arr[i + gap];
                        arr[i + gap] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
//            System.out.println("第" + (++count) + "次排序：");
//            System.out.println(Arrays.toString(arr));

        }
    }

    public static void shellInsertSort(int[] arr) {
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];
                int index = i;
                while (index - gap >= 0 && val < arr[index - gap]) {
                    arr[index] = arr[index - gap];
                    index -= gap;
                }
                arr[index] = val;
            }
//            System.out.println("第" + (++count) + "次排序：");
//            System.out.println(Arrays.toString(arr));

        }
    }
}
