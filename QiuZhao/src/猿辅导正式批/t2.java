//package TQP.YuanFuDao;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.List;
//import java.util.Random;
//import java.util.Stack;
//
//
///**
// * @author Geliang
// * @date 2021-07-31
// * @slogan 致敬大师，致敬未来的你！
// */
//public class t2 {
//    public static int xG;
//    public static int kG;
//    public static int ways = 0;
//    public static int mod = 10000019;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        while ((str = br.readLine()) != null) {
//            String[] s = str.split(" ");
//            int n = Integer.parseInt(s[0]);
//            int m = Integer.parseInt(s[1]);
//            int k = Integer.parseInt(s[2]);
//            int x = Integer.parseInt(s[3]);
//            xG = x;
//            kG = k;
//            s = br.readLine().split(" ");
//            int[] nums = new int[s.length];
//            for (int i = 0; i < s.length; i++) {
//                nums[i] = Integer.parseInt(s[i]);
//            }
//        }
//    }
//
//    public static void dfs(int curSum, int times, boolean f1, int target, List<Integer> l1, List<Integer> l2) {
//        if (times > target) {
//            if (curSum % xG == kG) {
//                ways++;
//                ways %= mod;
//            }
//            return;
//        }
//        if (f1){
//            f1=!f1;
//            for (int i = 0; i < l1.size(); i++) {
//                dfs(curSum*10+);
//            }
//        }
//    }
//}
