package datasource_sort.src.com.wgl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 万葛亮
 * @Date 2020 07 12 17:57
 * @GIRL friend 江珊
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]= (int) (Math.random()*10000);
        }
//        System.out.println(Arrays.toString(arr));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = dateFormat.format(date);
        System.out.println("排序前的时间为：" + s1);
        bubbleSort(arr);
        Date date2 = new Date();
        String s2 = dateFormat.format(date2);
        System.out.println("排序前的时间为：" + s2);//17s

}

    public static void bubbleSort(int[] arr){
        //冒泡排序
        int temp = 0;
        boolean flag =false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            int j=i+1;


            //为了提高优化效率，当上一次的已经是有序的情况下，直接return false
            if (!flag){
                break;
            }else {
                flag=false;
            }
            //            System.out.println("第"+j+"次排序的结果为: ");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
