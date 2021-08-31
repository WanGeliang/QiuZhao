package Shopee提前批;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Geliang
 * @date 2021-07-19
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {

    public static void main(String[] args) {
        t1 me = new t1();
//        System.out.println(me.getValue(3, 2));
//        List<Integer> list = me.get(3, 2);
//        for(int l:list) System.out.println(l);
        System.out.println(me
        .get(3,2));
    }
    public int getValue(int rowIndex, int columnIndex) {
        // write code here
        if(rowIndex/2>=columnIndex){

        }else{
            columnIndex=rowIndex+1-columnIndex;
        }
        int ans=1;
        int add=rowIndex-2;
        for(int i=1;i<=columnIndex-1;i++){
            ans+=add;
            add-=1;
        }
        return ans;
    }
    public int get(int rowIndex, int columnIndex){
        List<Integer> ans=new ArrayList<>();
        int N=rowIndex-1;
        long pre=1;
        ans.add(1);
        for(int k=1;k<=N;k++){
            long cur=pre*(N-k+1)/k;
            ans.add((int) cur);
            pre=cur;
        }
        return ans.get(columnIndex-1);
    }
}
