package datasource_tree.src.com.wgl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * @author 万葛亮
 * @Date 2020 07 29 11:46
 * @GIRL friend 江珊
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        // 创建要给80000个的随机的数组
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//		}

		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);


        adjustHeap(arr);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
//        System.out.println("排序后=" + Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr));
    }


    public static void adjustHeap(int[] arr){
        System.out.println("进行堆排序之前："+Arrays.toString(arr));
        int temp=0;
//      先构建大顶堆，思路是从左往右，从下网上开始比较
//      将无序序列构建成一个堆,根据升序或者降序的规则选择构建大顶堆还是小顶堆
        for (int i=arr.length/2-1;i>=0;i--){
            heapSort(arr,i,arr.length);
            System.out.println(Arrays.toString(arr));
        }

//      从已经找到的大顶堆开始
//      1.将堆顶元素与末尾元素交换,将最大元素沉到数组末端
//      2.重新调整结构,使其满足堆定义,然后继续交换堆顶元素和当前元素,反复执行+交换步骤,直到整个序列有序
        for (int i = arr.length-1; i >0 ; i--) {
            temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
//            System.out.println(Arrays.toString(arr));
            heapSort(arr,0,i);
        }
    }

    /**
     *
     * @param arr 我们待调整的数组
     * @param i 表示非叶子节点在数组中的索引位置
     * @param length   表示需要对多少个元素继续进行调整，length的长度是逐渐在减少的
     */
    public static void heapSort(int[] arr, int i, int length) {
//      先取出当前元素的值，保存在临时变量
        int temp = arr[i];
//      开始调整
//      说明：
//      1.j=2*i+1，其中j是i的左子节点
        for (int j = 2 * i + 1; j < length; j=2*j+1) {
//          需要比较左子节点与右子节点的大小
            if (j + 1 < length && arr[j] < arr[j + 1]) {
//              如果右子节点的值大，将j指向右子节点
                j++;
            }
//          再将我们刚刚的父节点的值与现在的左右节点的值进行比较
//          如果把较大的值，赋值给当前节点i这个位置
            if (arr[j]>temp){
                arr[i]=arr[j];
//              再将i指向子节点j，继续向下比较
                i=j;
            }else {
//              如果没有比当前节点i大的值，就没有必要再进行比较下去了，因为我们是从左往右，从下网上比较的
//              此时就可以直接break了
                break;
            }
        }
//      当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶部了
//      此时我们需要将temp值，放在我们刚刚调整后的位置
        arr[i]=temp;
    }
}

