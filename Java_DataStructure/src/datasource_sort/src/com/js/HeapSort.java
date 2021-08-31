package datasource_sort.src.com.js;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-07-13
 * @slogan 致敬大师，致敬未来的你！
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        System.out.println("前" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("后" + Arrays.toString(arr));
    }

    /**
     * 构建大顶堆或者小顶堆
     * 并开始交换
     *
     * @param arr
     */
    public static void heapSort(int arr[]) {
//      进行构建大顶堆

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
//      使用for循环交换值
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
//          继续从0开始调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 以当前i节点为父节点,调整元素
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
//          比较当前节点的左元素和右元素
//          需要再字节点找到更大的值
            if ((j + 1) < length && arr[j] < arr[j + 1]) {
                j++;
            }
//          如果当前元素是大于以i为父节点的话
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
//              这里直接退出的原因是:前面的调整堆,已经调整完成了
                break;
            }
        }
//      将当前最后的调整的值,交换为起初赋值的那个值
        arr[i] = temp;
    }
}
