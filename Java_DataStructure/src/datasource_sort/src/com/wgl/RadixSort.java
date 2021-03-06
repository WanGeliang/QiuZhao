package datasource_sort.src.com.wgl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 万葛亮
 * @Date 2020 07 16 16:19
 * @GIRL friend 江珊
 */
public class RadixSort {
    public static void main(String[] args) {
//        int arr[] = {8, 4, 5, 7, 1, 3, 6, 12}; //典型的时间换空间算法
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i]= (int) (Math.random()*10000);
        }
//        System.out.println(Arrays.toString(arr));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = dateFormat.format(date);
        System.out.println("排序前的时间为：" + s1);
        radixSort(arr);
        Date date2 = new Date();
        String s2 = dateFormat.format(date2);
        System.out.println("排序前的时间为：" + s2);//不到1s
//        System.out.println(Arrays.toString(arr));
    }

    public static void test1(int[] arr) {
        //基数排序方法
        //根据前面的推导过程，我们可以得到最终的基数排序代码
        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];
        //这里我们使用循环将代码处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;

            }
            //System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }
    }
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[10];
        //装入桶中
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digital = arr[j] / n % 10;
                bucket[digital][bucketCounts[digital]] = arr[j];
                bucketCounts[digital]++;
            }

            //从桶中取出
            int index = 0;
            for (int k = 0; k < bucketCounts.length; k++) {//这里是桶的个数
                if (bucketCounts[k] != 0) {
                    for (int l = 0; l < bucketCounts[k]; l++) {//bucketCounts[k]就是个数
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketCounts[k] = 0;
            }
        }
    }
}
