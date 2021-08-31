package datasource_sort.src.com.wgl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 万葛亮
 * @Date 2020 07 14 22:41
 * @GIRL friend 江珊
 */
public class QuickSort {
    public static void main(String[] args) {
//      int[] arr={ 48, 6, 57, 42, 60, 72, 83, 73, 88, 85};
        int[] arr={6,5,5};
//        System.out.println(Arrays.toString(arr));
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i]= (int) (Math.random()*10000);
//        }
//        System.out.println(Arrays.toString(arr));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = dateFormat.format(date);
        System.out.println("排序前的时间为：" + s1);
        quickSort(arr,0,arr.length-1);
        Date date2 = new Date();
        String s2 = dateFormat.format(date2);
        System.out.println("排序前的时间为：" + s2);//不到1s
    }

    //快速排序
    public static void quickSort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                    s[i] = s[j];
                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                    s[j] = s[i];
            }
            s[i] = x;
            quickSort(s, l, i - 1); // 递归调用
            quickSort(s, i + 1, r);
        }
    }
}
