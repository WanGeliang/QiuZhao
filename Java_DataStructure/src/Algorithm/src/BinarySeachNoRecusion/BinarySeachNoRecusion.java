package Algorithm.src.BinarySeachNoRecusion;

/**
 * @author 万葛亮
 * @Date 2020 08 06 16:14
 * @GIRL friend 江珊
 */
public class BinarySeachNoRecusion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(BinaryNoRecu(arr, -7));
    }

    public static int BinaryNoRecu(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
