package datasource_sort.src.com.wgl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 万葛亮
 * @Date 2020 07 12 20:52
 * @GIRL friend 江珊
 */
public class SelectSort {
    public static void main(String[] args) {

//        int[] arr={-1,-3,5,2,50,9};
//        selectBubble(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]= (int) (Math.random()*10000);
        }
//        System.out.println(Arrays.toString(arr));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = dateFormat.format(date);
        System.out.println("排序前的时间为：" + s1);
        selectBubble(arr);
        Date date2 = new Date();
        String s2 = dateFormat.format(date2);
        System.out.println("排序前的时间为：" + s2);//4s
    }

    public static void selectBubble(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex=i;
            int min=arr[i];
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j]<min){
                    min=arr[j];//重置初值
                    minIndex=j;
                }
            }
            if(minIndex!=i){//提高运行效率，当有重复的就不进行交换
                arr[minIndex]=arr[i];//交换
                arr[i]=min;
            }
        }
    }
}
