package 秋招360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 老师捞我 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] input = str.split(" ");
            int student = Integer.parseInt(input[0]);
            int p_acc = Integer.parseInt(input[1]);
            int q_acc = Integer.parseInt(input[2]);
            input = br.readLine().split(" ");
            int[] qmSore = new int[student];
            for (int i = 0; i < student; i++) {
                qmSore[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(qmSore);
            int count = 0;
            int[] psScore = new int[student];
            psScore[student - 1] = 100;
            for (int i = student - 2; i >= 0; i--) {
                if (qmSore[i] < qmSore[i + 1]) {
                    psScore[i] = psScore[i + 1] - 1;
                } else {
                    psScore[i] = psScore[i + 1];
                }
            }
            for (int i = 0; i < student; i++) {
                double score = (qmSore[i] * q_acc + psScore[i] * p_acc);
                if (score >= 6000) count++;
            }
            System.out.println(count);
        }
    }
}
