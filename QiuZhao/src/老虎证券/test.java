package 老虎证券;

/**
 * @author Geliang
 * @date 2021-08-16
 * @slogan 致敬大师，致敬未来的你！
 */
public class test {
    public static void main(String[] args) {
        int[] arr = {10, 0, 9, 7, 3};
        int maxDig = Integer.MIN_VALUE;
        int minNum=arr[arr.length-1];
        int maxNum=arr[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i--) {
            maxDig=Math.max(maxDig,Math.max(Math.abs(arr[i]-maxNum),Math.abs(arr[i]-minNum)));
            minNum=Math.min(minNum,arr[i]);
            maxNum=Math.max(maxNum,arr[i]);
        }
        System.out.println(maxDig);
    }
}
