package datasource_sort.src.com.js;

import java.util.Arrays;
import java.util.jar.JarOutputStream;
/**
 * @author Geliang
 * @date 2021-06-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class quickSortTest {
    public static void main(String[] args) {
//        int[] arr={2,4,1,6,5,7};
        int[] arr={6,5,5};
//        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
    }
//select *,count(socre )from score_tab order by score desc limit 2,1;
//    group by(score)
    /**
     * 降序排列
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int arr[],int left,int right){
        if(left>=right) return;
        int low=left,high=right;
        int pivot=arr[low];
        while(low<high){
            while(low<high&&pivot>=arr[high]){
                high--;
            }
            arr[low]=arr[high];
            while (low<high&&pivot<=arr[low]){
                low++;
            }
            arr[high]=arr[low];
            arr[low]=pivot;
        }
//        System.out.println(pivot+": 是第"+(low+1)+"大的");
        System.out.println(Arrays.toString(arr));
        quickSort(arr,left,low-1);
        quickSort(arr,low+1,right);
    }
}
