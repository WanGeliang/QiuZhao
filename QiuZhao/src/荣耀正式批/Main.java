package 荣耀正式批;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String words[] = str.split(",");
            int L = Integer.parseInt(br.readLine());
            int curLength = L;
            for (int i = 0; i < words.length; ) {
                curLength = L;
                int leftIndex = i;
                int rightIndex = i;
                while (i < words.length && curLength >= words[i].length()) {
                    curLength -= words[i].length();
                    rightIndex++;
                    i++;
                }
                int count = rightIndex - leftIndex;
                int lengthSum = 0;
                for (int j = leftIndex; j < rightIndex; j++) {
                    if (j < words.length) {
                        lengthSum += words[j].length();
                    }
                }
                int startCount = L - lengthSum;
                if (rightIndex >= words.length) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = leftIndex; j < rightIndex; j++) {
                        sb.append(words[j]);
                        if (sb.length() < L && startCount > 0) {
                            sb.append("*");
                            startCount--;
                        }
                    }
                    for (int m = sb.length(); m < L; m++) {
                        sb.append("*");
                    }
                    System.out.println(sb);
                } else {
                    if (count == 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(words[leftIndex]);
                        for (int m = 0; m < startCount; m++) {
                            sb.append("*");
                        }
                        System.out.println(sb);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        int singleStart = startCount / (count - 1);
                        int addStartNum = startCount - (singleStart * (count - 1));
                        for (int k = 0; k < addStartNum; k++) {
                            sb.append(words[k + leftIndex]);
                            for (int m = 0; m < singleStart; m++) {
                                sb.append("*");
                            }
                        }
                        for (int k = addStartNum; k < count - 1; k++) {
                            sb.append(words[k + leftIndex]);
                            for (int m = 0; m < singleStart; m++) {
                                sb.append("*");
                            }
                        }
                        sb.append(words[rightIndex - 1]);
                        System.out.println(sb);
                    }
                }
            }
        }
    }
}