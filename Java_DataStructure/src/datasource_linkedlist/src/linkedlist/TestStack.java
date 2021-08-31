package datasource_linkedlist.src.linkedlist;

import org.junit.Test;

import java.util.Stack;

/**
 * @author 万葛亮
 * @Date 2020 06 28 20:57
 * @GIRL friend 江珊
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("smith");
        stack.add("james");
        stack.add("kobe");
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    @Test
    public void test1(){
        int num1=0;
        int num2=0;
        int[] array=new int[]{1,2,3,4,5,4,2};
        int[] sum=new int[2];
        int m=0;
        int i=0;
        int j=0;
        for(i=0;i<array.length;i++){
            for(j=i+1;j<array.length;j++){
            if(array[i]==array[j]){
                sum[m]=array[i];
                m++;
            }
        }
        }
        num1=sum[0];
        num2=sum[1];
        System.out.println(num1+"*****"+num2);
    }


}



