package datasource_search.src.com.wgl;

/**
 * @author 万葛亮
 * @Date 2020 07 21 16:47
 * @GIRL friend 江珊
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i]=i+1;
//            System.out.println(arr[i]);
        }
        System.out.println(insertSearch(arr, 0, arr.length - 1, 100));
    }
    public static int insertSearch(int[] arr,int left,int right ,int findValue){
        if(left>right||arr[left]>findValue||arr[right]<findValue){
            return -1;
        }
        int mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
        if (arr[mid]<findValue){
            return insertSearch(arr,mid+1,right,findValue);
        }else if (arr[mid]>findValue){
            return insertSearch(arr,left,mid-1,findValue);
        }else return mid;
    }
}
