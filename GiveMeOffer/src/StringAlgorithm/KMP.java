package StringAlgorithm;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String s1="aabaaf";
        String s2="aabaabaaf";
        int[] next=getNext(s1);
        System.out.println(Arrays.toString(next));
        // 再根据next数组进行模式匹配
        System.out.println(isMatched(s1,s2,next));
    }

    public static boolean isMatched(String s1,String s2,int[] next){
        int j=0;//此时j指向的是模式串的值
        for (int i = 0; i < s2.length(); i++) {
            while(j>0&&s1.charAt(j)!=s2.charAt(i)){
                j=next[j-1];
            }
            if(s1.charAt(j)==s2.charAt(i)){
                j++;
            }
            // 应该在这里进行判断，这里不需要对next数组进行操作
            if(j==s1.length())return true;
        }
        return false;
    }

    /**
     * 为什么使用前缀表就能知道匹配失败之后跳到哪里进行重新匹配？
     * 模式串  aabaaf
     * 文本串  aabaabaaf
     * 当我们匹配失败时，找到匹配的失败前的子字符串，这部分的最长相等的前缀和和后缀字符串是一个子字符串aa
     *
     * 因为我们找到了最长相等的前缀和后缀，匹配失败的位置就是后缀字串的后面，那么我们找到与其相同的前缀的后面就可以进行重新匹配了。
     *
     * @param s
     *          前缀：除了最后一个字符以外，一个字符串的全部头部组合。
     *          后缀：除第一个字符以外，一个字符串的全部尾部组合。
     * @return
     *          next数组是什么？
     *          代表一个前缀表，用来回溯的，它记录了模式串与主串（文本串）不匹配的时候，模式串应该从哪里开始重新匹配
     *          前缀表里面的数值代表着：当前位置的字串有多大长度相同的前缀和后缀。
     *
     *
     *          为什么要看前一个字符的前缀表的数值？
     *          因为要找前面字符串的最长相同的前缀和后缀。
     */
    public static int[] getNext(String s){
        int[] next=new int[s.length()];
        // 初始化，求next数组
        // 初始化数组肯定是为0的
        next[0]=0;
        int j=0,i=1;
        for (i = 1; i < s.length(); i++) {
            // 不相等就进行跳转 j=next[j-1]
            while(j>0&&s.charAt(i)!=s.charAt(j)){
                j=next[j-1];
            }
            // 如果匹配，就将j+1
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

}
