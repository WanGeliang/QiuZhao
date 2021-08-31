package Test;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-06-21
 * @slogan 致敬大师，致敬未来的你！
 */
public class quickSort {
    public static void main(String[] args) {
        int[] arr={5,1,6,2,5};
        System.out.println(Arrays.toString(arr));
        quSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quSort(int[] array, int L, int R) {
        if (L > R) return;
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
        quSort(array, L, left - 1);
        quSort(array, left + 1, R);
    }
}
