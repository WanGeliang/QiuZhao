package datasource_search.src.com.wgl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 万葛亮
 * @Date 2020 07 18 14:57
 * @GIRL friend 江珊
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7};//二分查找必须是有序数组
//        List i = BianrySearch(arr, 0, arr.length - 1, 2);
//        System.out.println("二分查找的索引值：" + i);
//        System.out.println(binarySearch(arr, 0, arr.length, 4));
//        System.out.println();
//        System.out.println(whileBinarySearch(arr, 2));
//        System.out.println(leftBinarySearch(arr, 3));
        System.out.println();
//        System.out.println(rightBinarySearch(arr,3));
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println(getMostLeft(arr, 2));
        System.out.println(getMostRight(arr, 2));
//        System.out.println(Arrays.toString(arr));
    }

    //寻找右侧边界的二分查找
    public static int rightBinarySearch(int[] arr, int target) {
        int length = arr.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || arr[right] != target) {
            return -1;
        }
        return right;
    }

    //寻找左侧边界的二分查找
    //方式一:[left,right]和[left,right)两种方式,就
    public static int leftBinarySearch(int[] arr, int target) {
        int length = arr.length;
//        int right=length-1;
//        int left=0;
//        while(left<=right){
//            int mid=left+(right-left)/2;
//            if (arr[mid]==target){
//                right=mid-1;
//            }else if (arr[mid]<target){
//                left=mid+1;
//            }else if (arr[mid]>target){
//                right=mid-1;
//            }
//        }
//        if (left>=length||arr[left]!=target){
//            return -1;
//        }
//        return left;

        int right = length;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid;
            }
        }
        if (left >= length || arr[left] != target) {
            return -1;
        }
        return left;
    }

    //while循环的方式
    public static int binarySearch(int[] arr, int left, int right, int findValue) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (findValue > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }

    public static int whileBinarySearch(int[] arr, int target) {
        int length = arr.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static List<Integer> BianrySearch(int[] arr, int left, int right, int findValue) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        if (findValue > arr[mid]) {
            return BianrySearch(arr, mid + 1, right, findValue);
        } else if (findValue < arr[mid]) {
            return BianrySearch(arr, left, mid - 1, findValue);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(mid);
            int i = mid - 1;
            while (i >= 0 && arr[i] == arr[mid]) {
                list.add(i);
                i--;
            }
            int j = mid + 1;
            while (j < arr.length && arr[j] == arr[mid]) {
                list.add(j);
                j++;
            }
            return list;
        }
    }

    //统一的闭区间，寻找最左，最右的下标值
    public static int getMostLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= arr.length || arr[left] != target) return -1;
        return left;
    }

    //最右边届
    public static int getMostRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || arr[right] != target) return -1;
        return right;
    }
}
