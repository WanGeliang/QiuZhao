package Top_K_problem;

import StringAlgorithm.KMP;

/**
 * @author Geliang
 * @date 2021-07-13
 * @slogan 致敬大师，致敬未来的你！
 */
public class quickSort_method {
    public static void main(String[] args) {
        int[] arr={1,4,7,9,6,3,5,8,2};
        int k=4;
        topK(arr,0,arr.length-1,k);
        for(int i=0;i<k;i++){
            System.out.println("top K:"+(i+1)+": "+arr[i]);
        }
    }

    public static void topK(int[] arr,int left,int right,int K){
        if(left>=right) return;
        int L=left,R=right;
        int pivot=arr[left];
        while(L<R){
            while (L<R&&arr[R]<=pivot) R--;
            arr[L]=arr[R];
            while (L<R&&arr[L]>=pivot) L++;
            arr[R]=arr[L];
            arr[L]=pivot;
        }
        if(L>K-1){
            topK(arr,left,L-1, K);
            topK(arr,L+1,right, K);
        }
        if(L==K-1) return;
    }
}
