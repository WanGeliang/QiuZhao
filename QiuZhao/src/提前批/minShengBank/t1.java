package 提前批.minShengBank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Geliang
 * @date 2021-06-26
 * @slogan 致敬大师，致敬未来的你！
 * 3
 * zhang 90 80 68
 * li 91 90 65
 * wang 73 90 66
 */
public class t1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        str=br.readLine();
        int n=Integer.parseInt(str);
        Stu[] StuArray=new Stu[n];
        for (int i = 0; i < n; i++) {
            str=br.readLine();
            String[] temp=str.split(" ");
            StuArray[i]=new Stu();
            for (int j = 0; j < temp.length; j++) {
                StuArray[i].name=temp[0];
                StuArray[i].chinese=Integer.parseInt(temp[1]);
                StuArray[i].math=Integer.parseInt(temp[2]);
                StuArray[i].english=Integer.parseInt(temp[3]);
                StuArray[i].total=StuArray[i].chinese+StuArray[i].math+StuArray[i].english;
            }
        }
        // 排序
//        Comparator<Stu> cmp=new Comparator<Stu>() {
//            @Override
//            public int compare(Stu o1, Stu o2) {
//                if(o2.total>o1.total){
//                    if(o2.total==o1.total){
//                        if(o2.chinese>o1.chinese){
//                            if(o2.chinese==o1.chinese){
//                                if(o2.math>o1.math){
//                                    if(o2.math==o1.math){
//                                        if(o2.english>o1.english){
//                                            if(o2.english==o1.english){
//                                                if(o2.name.compareTo(o1.name)>0){
//                                                    return -1;
//                                                }
//                                            }
//                                            return 1;
//                                        }
//                                    }
//                                    return 1;
//                                }
//                            }
//                            return 1;
//                        }
//                    }
//                    return 1;
//                }
//                return 0;
//            }
//        };

        Arrays.sort(StuArray, new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                if (o1.total == o2.total) {
                    if (o1.chinese == o2.chinese) {
                        if (o2.math == o1.math) {
                            if (o1.english == o2.english) {
                                if (o1.name.compareTo(o2.name) > 0) {
                                    return 1;
                                } else {
                                    return -1;
                                }
                            } else {
                                // return 负数：代表我是不想调整的
                                if (o1.english > o2.english) {
                                    return -1;
                                }
                                return 1;
                            }
                        } else {
                            if (o1.math > o2.math) {
                                return -1;
                            }
                            return 1;
                        }
                    } else {
                        if (o1.chinese > o2.chinese) {
                            return -1;
                        }
                        return 1;
                    }
                } else {
                    if (o1.total > o2.total) {
                        return -1;
                    }
                    return 1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println("rank:"+(i+1)+StuArray[i]);
        }
    }
}

class Stu{

    String name;
    int total;
    int chinese;
    int math;
    int english;

    @Override
    public String toString() {
        return
                " name:" + name +
                " total:" + total +
                " chinese:" + chinese +
                " math:" + math +
                " english:" + english
                ;
    }

}
