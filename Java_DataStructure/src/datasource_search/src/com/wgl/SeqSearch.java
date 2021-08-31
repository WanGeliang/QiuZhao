package datasource_search.src.com.wgl;

/**
 * @author 万葛亮
 * @Date 2020 07 16 20:12
 * @GIRL friend 江珊
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[]arr={4,52,8,-1,76,3};
        int i = SeqSearch(arr, 52);
        System.out.println("索引值："+i);
    }
    public static int SeqSearch(int[] arr,int i){
        for (int j = 0; j < arr.length; j++) {
            if (i==arr[j]){
                return j;
            }

        }
            return -1;
    }
}
