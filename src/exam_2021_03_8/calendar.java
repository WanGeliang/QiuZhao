package exam_2021_03_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class calendar {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 给定年份和月份，按照输出当月日历
     *
     * @param year int 年份
     * @param month int 月份(1-12)
     * @param dayOfWeek int 当月1号是星期几，1表示星期一，7表示星期天
     * @return stringArrayList<ArrayList <>>
     */
    ArrayList<ArrayList<String>> resList = new ArrayList();
    ArrayList<String> subList = new ArrayList();

    public ArrayList<ArrayList<String>> calendar(int year, int month, int dayOfWeek) {

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);//由于java中是从0开始计数，所以需要-1
        int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1;//当月首日是周几，同样的道理
        int maxDay = (cal.getActualMaximum(Calendar.DAY_OF_MONTH));//获取当月最大的天数

        for (int i = 1; i < startDay; i++) {
            subList.add("\"\"");
        }

        for (int i = 1; i <= maxDay; i++) {
            subList.add(i + "");
            if (subList.size() >= 7) {
                resList.add(subList);
                subList = new ArrayList<>();
            }
        }
        int cha=7-subList.size();
        for (int i = 0; i < cha; i++) {
            subList.add("\"\"");
        }
        resList.add(subList);
        System.out.println(Arrays.toString(resList.toArray()));
        return resList;
    }
}
