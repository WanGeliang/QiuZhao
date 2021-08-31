package Shopee提前批.js;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-02
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {


    public static void main(String[] args) {

        int length = 25; //杆的长度
        int ant_num = 3; //蚂蚁数量
        double[] list_pos = {3, 9, 18};  //蚂蚁初始位置
        double speed = 1.0; //蚂蚁的速度
        max_time = 0; //最长时间
        min_time = 25; //最短时间 初始化为最大值，避免出现一只蚂蚁的情况
        int[] res = cal_time(length, list_pos, ant_num, speed);
        System.out.println(Arrays.toString(res));
    }

    static double max_time;
    static double min_time;

    public static int[] cal_time(int length, double[] list_pos, int ant_num, double speed) {
        double temp_max = 0;
        double temp_min = 0;
        for (int i = 0; i < ant_num; i++) {
            temp_max = 0;
            temp_min = 0;
            if (list_pos[i] < length / 2) {
                temp_max = ((length - list_pos[i]) / speed);
                temp_min = (list_pos[i] / speed);
            } else {
                temp_min = ((length - list_pos[i]) / speed);
                temp_max = (list_pos[i] / speed);
            }
            max_time = Math.max(max_time, temp_max);
            min_time = Math.min(min_time, temp_min);
        }

        int[] res = new int[2];
        res[0] = (int) min_time;
        res[1] = (int) max_time;
        return res;
    }
}
