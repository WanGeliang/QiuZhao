package 一点咨询;

/**
 * @author Geliang
 * @date 2021-07-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    public static void main(String[] args) {
        String s1 = "2.0.1";
        String s2 = "2.1.13";
        System.out.println(s1.compareTo(s2));
//        System.out.println(Arrays.toString(s2.split("\\.")));
    }

    /**
     * 版本号比对：
     * @param version_list
     * @return
     */
    public int[] max_version (String[][] version_list) {
        // write code here
        int[] res = new int[version_list.length];
        for (int i = 0; i < version_list.length; i++) {
            if (version_list[i][0] == null || version_list[i][1] == null) return res;

            String[] s1 = version_list[i][0].split("\\.");
            String[] s2 = version_list[i][1].split("\\.");
            int m = s1.length, n = s2.length, index = 0;
            int x = 0, y = 0;
            int result = -2;
            while (x < m && y < n) {
                result = Integer.compare(Integer.parseInt(s1[x]), Integer.parseInt(s2[y]));
                //result = s1[x].compareTo(s2[y]);
                if (result == -1) {
                    res[i] = 2;
                    break;
                }
                if (result == 1) {
                    res[i] = 1;
                    break;
                }
                x++;
                y++;
            }
            if (result == 0) {
                // 通过全部用例
                res[i] = m - n < 0 ? 2 : 1;
            }
        }
        return res;
    }
}
