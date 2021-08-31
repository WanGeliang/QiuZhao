package 荣耀软开0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder resSb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            for (int i = 0; i < s.length; i++) {
                StringBuilder subSb = new StringBuilder();
                int hengCount=0;
                String subStr=s[i];
                for (int j = 0; j < subStr.length(); j++) {
                    char c=subStr.charAt(j);
                    if(c=='-'){
                        if(j==0||j==subStr.length()-1){
                           continue;
                        }else {
                            hengCount++;
                        }
                        if(hengCount==2){
                            char post=subStr.charAt(j+1);
                            char pre=subStr.charAt(j-2);
                            if(('a'<=pre&&pre<='z')||('A'<=pre&&pre<='Z')&&('a'<=post&&post<='z')||('A'<=post&&post<='Z')){
                                subSb.append(" ");
                            }else {
                                subSb.append(" ");
                            }
                        }
                    }
                    if('0'<=c&&c<='9'){
                        subSb.append(c);
                    }
                    if(c=='-'&&('0'<=subStr.charAt(j-1)&&subStr.charAt(j-1)<='9')){
                        subSb.append('-');
                    }
                    if(('a'<=c&&c<='z')||('A'<=c&&c<='Z')){
                        subSb.append(c);
                    }
                }
               resSb.append(subSb).append(" ");
            }
            String[] resStr = resSb.toString().trim().split(" ");
            StringBuilder res = new StringBuilder();
            for (int i = resStr.length - 1;i>=0; i--) {
                if(resStr[i].equals("")||resStr.equals(" "))continue;
                res.append(resStr[i]+" ");
            }
            System.out.println(res.toString().trim());
        }
    }
}
