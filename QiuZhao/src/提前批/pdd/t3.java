package 提前批.pdd;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-06-23
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    public static void main(String[] args) {
        int[] arr={1,3,2};
        int k=2;
        int n=3;
//        int[] arr={1,3,2,9,0};
//        int k=3;
//        int n=5;
        int count=0;
        int[] temp=new int[k];
        temp=arr;
        for(int i=0;i<=n-k;i++){
//            System.arraycopy(arr,i,temp,0,k);
            Arrays.sort(temp,i,i+k);
            System.out.println(Arrays.toString(arr));
            count+=temp[(i+i+k-1)/2];
        }

        System.out.println(count);
    }
}
