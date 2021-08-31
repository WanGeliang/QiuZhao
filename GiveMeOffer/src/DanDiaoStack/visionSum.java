package DanDiaoStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class visionSum {
    public static void main(String[] args) {
        int[] arr={4,3,7,1};
        System.out.println(getSum(arr));
//        int[] res=new int[arr.length+1];
//        System.arraycopy(arr,0,res,0,arr.length);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i]);
//        }
    }

    public static int getVision(int[] nums){
        Stack<Integer> stack =new Stack<>();
        int[] arr=new int[nums.length+1];
//        for (int i = 0; i < nums.length; i++) {
//            arr[i]=nums[i];
//        }
        System.arraycopy(nums,0,arr,0,nums.length);
        arr[arr.length-1]=Integer.MAX_VALUE;//认为最后一个作为最大值，不然无法最后原数组无法出栈
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()||arr[stack.peek()]>arr[i]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&arr[stack.peek()]<=arr[i]){
                    int top=stack.peek();
                    stack.pop();
                    sum+=(i-top-1);

                }
                stack.push(i);
            }
        }
        //单调栈：该方法可行
//        for (int i = 0; i < arr.length; i++) {
//            if(stack.isEmpty()){
//                stack.push(arr[i]);
//            }else{
//                while(!stack.isEmpty()&&stack.peek()<arr[i]){
//                    stack.pop();
//                }
//                sum+=stack.size();
//                stack.push(arr[i]);
//            }
//        }
        return sum;
//        return 0;
    }

    public static int getStack(int[] arr){
        if(arr==null||arr.length==0) return 0;
        int sum=0;
        Stack<Integer> stack=new Stack<>();
        int[] res = new int[arr.length + 1];
        res[res.length-1]=Integer.MAX_VALUE;
        System.arraycopy(arr,0,res,0,arr.length);
        for (int i = 0; i < res.length; i++) {
            if(stack.isEmpty()||res[stack.peek()]>res[i]){
                stack.push(i);
            }else {
                while(!stack.isEmpty()&&res[stack.peek()]<=res[i]){
                    int top=stack.pop();
                    sum+=(i-top-1);
                }
                stack.push(i);
            }
        }
        return sum;
    }

    public static int getSum(int[] arr){

        int sum=0;
        int[] temp=new int[arr.length+1];
        System.arraycopy(arr,0,temp,0,arr.length);
        temp[temp.length-1]=Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            // 入栈
//            if (stack.isEmpty()||temp[stack.peek()]>=temp[i]){
//                stack.push(i);
//            }else{
                while(!stack.empty()&&temp[stack.peek()]<temp[i]){
                    int top=stack.pop();
                    sum+=i-top-1;
                }
                stack.push(i);
            }
//        }
        return sum;
    }

    
}
