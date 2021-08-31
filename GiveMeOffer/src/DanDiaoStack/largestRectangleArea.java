package DanDiaoStack;

import java.util.Stack;

public class largestRectangleArea {
    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        int res=getArea(arr);
        System.out.println(res);
    }
    public static int getArea(int[] arr){
        int res=0,top=0;
        int temp[]=new int[arr.length+1];
        System.arraycopy(arr,0,temp,0,arr.length);
        temp[temp.length-1]=-1;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            if(stack.isEmpty()||temp[stack.peek()]<=temp[i]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&temp[stack.peek()]>temp[i]){
                    top=stack.pop();
                    res=Math.max(res,(i-top)*temp[top]);
                }
                stack.push(top);
                temp[top]=temp[i];
            }
        }
        return res;
    }


}
