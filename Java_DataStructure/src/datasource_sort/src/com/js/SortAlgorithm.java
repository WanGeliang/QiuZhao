package datasource_sort.src.com.js;


import com.sun.corba.se.impl.protocol.RequestDispatcherRegistryImpl;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] array = {15, 2, 78, 12, 7, 366, 35, 1};
        SortAlgorithm mt = new SortAlgorithm();
//        Executor executor=new ThreadPoolExecutor()
        //********************
//        System.out.println("冒泡排序前。。。。");
//        for (int i : array) {
//            System.out.print(i);
//        }
//        mt.bubbleSort(array);
//        System.out.println();
//        System.out.println("排序后。。。。");
//        for (int i : array) {
//            System.out.print(i);
//        }
        //********************
        //********************
//        System.out.println("选择排序前。。。。");
//        for (int i : array) {
//            System.out.print(i);
//        }
//        mt.SelectSort(array);
//        System.out.println();
//        System.out.println("排序后。。。。");
//        for (int i : array) {
//            System.out.print(i);
//        }
//        //********************

        //********************
        System.out.println("插入排序前。。。。");
        for (int i : array) {
            System.out.print(i + " ");
        }
//        mt.MergeSort(array, 0, array.length - 1);
        mt.quSort(array, 0, array.length - 1);
        System.out.println();
        System.out.println("插入排序后。。。。");
        for (int i : array) {
            System.out.print(i + " ");
        }
        //********************
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void bubbleSort(int[] array) {

        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    //
    public void bbSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    /**
     * 选择排序
     * 每次选择最小的一个放在前面
     */
    public void SelectSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    int temp = array[j];
                    array[j] = minValue;
                    minValue = temp;
                }

            }
            array[i] = minValue;
        }
    }

    public void sleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int res = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < res) {
                    int temp = res;
                    res = array[j];
                    array[j] = temp;
                }
            }
            array[i] = res;

        }
    }

    /**
     * 插入排序
     * 从前面排好序的数组中进行插入
     *
     * @param array
     */
    public void InsertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            int index = i - 1;
//            while (index >= 0 && val < array[index]) {//注意点在这个val身上，插入的是每一个值
//                array[index + 1] = array[index];
//                index--;
//            }
//            array[index + 1] = val;
            while (index >= 0 && val < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = val;
        }
    }

    public void inSort(int[] array) {
        if (array.length <= 1) return;
        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            int index = i - 1;
            while (index >= 0 && array[index] >= val) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = val;
        }
    }

    /**
     * 希尔排序
     *
     * @param array
     */
    public void ShellSort(int[] array) {

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        int temp = array[j + gap];
                        array[j + gap] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * 快速排序
     * 给定一个基准值，进行排序
     *
     * @param array
     * @param L
     * @param R
     */
    public void QuickSort(int[] array, int L, int R) {
        if (L >= R) return;
        int left = L;
        int right = R;

        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
            array[left] = pivot;
        }
        QuickSort(array, L, right - 1);
        QuickSort(array, right + 1, R);

    }

    public void quSort(int[] array, int L, int R) {
        if (L >= R) return;
        int left = L;
        int right = R;
        while (left < right) {
            int pivot = array[left];
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
            array[left] = pivot;
            quSort(array, L, left - 1);
            quSort(array, left + 1, R);

        }
    }

    /**
     * 归并排序
     *
     * @param array
     * @param left
     * @param right
     */
    public void MergeSort(int[] array, int left, int right) {
        //终止条件
        if (array == null || left == right) return;
        //首先将数组划分为最小
        int mid = left + (right - left) / 2;
        MergeSort(array, left, mid);
        MergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    //归并排序的辅助方法
    public void merge(int[] array, int left, int mid, int right) {
//      创建一个临时数组,用于保存区间中的个数
        int[] help = new int[right - left + 1];
//      左指针
        int lPoint = left;
//      右指针
        int rPoint = mid + 1;
        int tempPoint = 0;
        while (lPoint <= mid && rPoint <= right) {
            if (array[lPoint] <= array[rPoint]) {
                help[tempPoint++] = array[lPoint++];
            } else {
                help[tempPoint++] = array[rPoint++];
            }
        }
        while (lPoint <= mid) {
            help[tempPoint++] = array[lPoint++];
        }
        while (rPoint <= right) {
            help[tempPoint++] = array[rPoint++];
        }
//      将原来的数组进行赋值
        for (int i = 0; i < help.length; i++) {
            // 从left的位置开始赋值
            array[left + i] = help[i];
        }
    }


    /**
     * 计数排序:适用于正整数
     *
     * @param array
     */
    public void CountSort(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] countArray = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                array[index++] = i;
            }
        }
    }

    //计数排序改进
    public void CountSort1(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        //构建数组
        int[] count = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }
        //次数叠加
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] tempArray = new int[array.length];
        //根据索引将数据放入temp
        for (int i = array.length - 1; i >= 0; i--) {
            //--代表在排序数组中的作用
            tempArray[--count[array[i] - min]] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tempArray[i];
        }
    }

    public void RadixSort(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        for (int divider = 1; divider <= max; divider *= 10) {
            HelpRadix(divider, array);
        }
    }

    public void HelpRadix(int divider, int[] array) {
        int[] count = new int[10];
        for (int i = 0; i < array.length; i++) {
            count[array[i] / divider % 10]++;
        }
        //同计数排序，进行累加计数
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        //倒着遍历
        int[] temp = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            temp[--count[array[i] / divider % 10]] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }

    /**
     * 桶排序
     *
     * @param array
     */
    public void BucketSort(int[] array) {
        int size = 0;
    }
}
