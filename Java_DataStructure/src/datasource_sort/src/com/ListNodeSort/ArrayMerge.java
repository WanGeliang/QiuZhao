package datasource_sort.src.com.ListNodeSort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Geliang
 * @date 2021-06-27
 * @slogan 致敬大师，致敬未来的你！
 */
public class ArrayMerge {
    public static void main(String[] args) {
        int[] arr={3,5,6,4,1};
        System.out.println(Arrays.toString(arr));
        //先要将数组分成两段，再进行合并
        helpMerge(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        PriorityQueue<Integer> queue=new PriorityQueue(((o1, o2) -> o1));
//        queue.offer()
//        queue.poll();
    }

    public static void helpMerge(int[] arr, int left, int right){
        if(left>=right) return ;
        int mid=left+(right-left)/2;
        helpMerge(arr,left,mid);
        helpMerge(arr,mid+1,right);
        // 开始正式排序合并
        // 将数组从整个数组中分为两段，一段是left,mid
        // 再就是从mid+1,right，就是进行平分数组
        mergeSort(arr,left,mid,right);
    }
    public static void mergeSort(int[] arr,int left,int mid,int right){
        if(left>=right) return;
        int[] temp=new int[right-left+1];

        // 这里定义两个指针，进行比较
        int i=left,j=mid+1,n=0;
        while(i<=mid&&j<=right){
            if(arr[i]<arr[j]){
                temp[n]=arr[i++];
            }else{
                temp[n]=arr[j++];
            }
            n++;
        }
        while(i>mid&&j<=right){
            temp[n++]=arr[j++];
        }
        while(i<=mid&&j>right){
            temp[n++]=arr[i++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left+k]=temp[k];
        }
    }

}
