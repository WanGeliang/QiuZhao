package datasource_tree.src.com.wgl;

/**
 * @author 万葛亮
 * @Date 2020 07 26 17:16
 * @GIRL friend 江珊
 */
public class ArrBinaryTree {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        BinaryTreeArr treeArr = new BinaryTreeArr(arr);
//        treeArr.preSearch();
//        treeArr.midSearch();
        treeArr.postSearch();
    }

}

class BinaryTreeArr{
    private int[] arr;
    public BinaryTreeArr(int[] arr){
        this.arr=arr;
    }
    public void preSearch(){
        this.preSearch(0);
    }
    public void  midSearch(){
        this.midSearch(0);
    }
    public void postSearch(){
        this.postSearch(0);
    }
    //前序存储到数组中
    public void preSearch(int index){
        if (arr.length==0||arr==null){
            System.out.println("数组为空，无法进行遍历~~~");
        }
        System.out.println(arr[index]);
        if ((2*index+1)<arr.length){
            preSearch(2*index+1);
        }
        if ((2*index+2)<arr.length){
            preSearch(2*index+2);
        }
    }
    //中序存储到数组中
    public void midSearch(int index){
        if (arr.length==0||arr==null){
            System.out.println("数组为空，无法进行遍历~~~");
        }
        if ((2*index+1)<arr.length){
            midSearch(2*index+1);
        }
        System.out.println(arr[index]);
        if ((2*index+2)<arr.length){
            midSearch(2*index+2);
        }
    }
    //后序存储到数组中
    public void postSearch(int index){
        if (arr.length==0||arr==null){
            System.out.println("数组为空，无法进行遍历~~~");
        }
        if ((2*index+1)<arr.length){
            postSearch(2*index+1);
        }
        if ((2*index+2)<arr.length){
            postSearch(2*index+2);
        }
        System.out.println(arr[index]);
    }
}
