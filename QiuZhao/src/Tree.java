/**
 * @author Geliang
 * @date 2021-07-12
 * @slogan 致敬大师，致敬未来的你！
 */
public class Tree {
    public static void main(String[] args) {
//        根节点
        Tr root=new Tr(-1);
        root.left=new Tr(2);
        root.right=new Tr(3);
        System.out.println("反转前："+root);
        reverse(root);
        System.out.println("反转后："+root);
    }

    public static Tr reverse(Tr root){
        if(root==null) return root;
//      赋予一个临时节点
        Tr temp=root.left;
        root.left=root.right;
        reverse(root.left);
        root.right=temp;
        reverse(root.right);
        return root;
    }
}

//定义一个二叉树
class Tr{
    public Tr(int val){
        this.val=val;
    }
    int val;
    Tr left;
    Tr right;

    @Override
    public String toString() {
        return "Tr{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}