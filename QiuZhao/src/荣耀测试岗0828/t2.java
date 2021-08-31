package 荣耀测试岗0828;


import java.util.*;

public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace("[", "").replace("]", "");
        String[] s = str.split(",");
        int[] nums = Arrays.asList(s).stream().mapToInt(Integer::parseInt).sorted().toArray();
        int[] temp = new int[]{-1, -1, -1, -1, -1, -1};
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                getCondition(nums, temp, i, 2);
            } else if (i == 1) {
                if (temp[0] != 2 && temp[0] != -1) {
                    getCondition(nums, temp, i, 9);
                } else {
                    getCondition(nums, temp, i, 3);
                }
            } else if (i == 2) {
                getCondition(nums, temp, i, 5);
            } else if (i == 3) {
                getCondition(nums, temp, i, 9);
            } else if (i == 4) {
                getCondition(nums, temp, i, 5);
            } else if (i == 5) {
                getCondition(nums, temp, i, 9);
            }
        }
        String retstr = "";
        for (int k = 0; k < temp.length; k++) {
            if (k % 2 == 0) {
                retstr += temp[k];
            } else {
                retstr += temp[k] + ":";
            }
        }
        if (retstr.contains("-1")) {
            System.out.println("invalid");
        } else {
            System.out.println(retstr.substring(0, retstr.length() - 1));
        }
    }

    public static void getCondition(int[] intsp, int[] ret, int i, int reqInt) {
        for (int j = intsp.length - 1; j >= 0; j--) {
            if (intsp[j] <= reqInt && intsp[j] != -1) {
                ret[i] = intsp[j];
                intsp[j] = -1;
                break;
            }
        }
    }
}
