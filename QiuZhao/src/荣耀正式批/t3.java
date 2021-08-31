package 荣耀正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * goudan2 60 80 80
 * zhaowu 60 80 80
 * zhangsan 60 80 80
 * yatou 90 80 80
 * goudan1 60 80 80
 * gousheng 80 100 60
 * lilei 80 100 60
 * hanmingmei 80 90 60
 * liutao 80 100 60
 * SimonYin 80 100 60
 */
public class t3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Score[] sc = new Score[10];
        int count = 0;
        for (int i = 0; i < 10; i++) {
            str = br.readLine();
            String[] s = str.split(" ");
            if (s == null || s.length < 1) continue;
            boolean flag = false;
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("") && s[j] == null) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            int chinese = Integer.parseInt(s[1]);
            int math = Integer.parseInt(s[2]);
            int english = Integer.parseInt(s[3]);
            String name = s[0];
            if (name != null && !name.equals("") && chinese >= 60 && math >= 60 && english >= 60) {
                sc[i] = new Score(name, chinese, math, english);
                count++;
            }
        }
        br.close();

        Score[] hh = new Score[count];

        System.arraycopy(sc, 0, hh, 0, count);
        Arrays.sort(hh, 0, count);
//        System.out.println(Arrays.toString(sc));
        System.out.println("[First round name list]");
        for (int i = 0; i < count; i++) {
            System.out.println(hh[i]);
        }
        System.out.println();

        System.out.println("[Final name list]");
        for (int i = 0; i < 3; i++) {
            System.out.println(hh[i]);
        }
    }
}

class Score implements Comparable<Score> {
    String name;
    int chinese;
    int math;
    int english;
    int total;
    int num;

    public Score(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.total = chinese + math + english;
    }

    @Override
    public String toString() {
        return
                "name=" + name +
                        "  chinese=" + chinese +
                        "  math=" + math +
                        "  english=" + english;
    }

    @Override
    public int compareTo(Score o) {
        if (this.total > o.total) {
            return -1;
        }
        if (this.total < o.total) {
            return 1;
        } else {
            if (this.chinese > o.chinese) {
                return -1;
            } else if (this.chinese < o.chinese) {
                return 1;
            } else {
                if (this.math > o.math) {
                    return -1;
                } else if (this.math < o.math) {
                    return 1;
                } else {
                    if (this.english > o.english) {
                        return -1;
                    } else if (this.english < o.english) {
                        return 1;
                    } else {
                        return this.name.compareTo(o.name);
                    }
                }
            }
        }
    }
}
