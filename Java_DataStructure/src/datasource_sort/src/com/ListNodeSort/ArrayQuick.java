package datasource_sort.src.com.ListNodeSort;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-06-26
 * @slogan 致敬大师，致敬未来的你！
 */
public class ArrayQuick {
    public static void main(String[] args) {
        int[] arr={4,2,3,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left ,int right){
        if(left>=right) return;
        int L=left;
        int R=right;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>pivot){
                right--;
            }
            arr[left]=arr[right];
            while (left<right&&arr[left]<pivot){
                left++;
            }
            arr[right]=arr[left];
            arr[left]=pivot;
        }
        quickSort(arr,L,left-1);
        quickSort(arr,left+1,R);
    }
}
