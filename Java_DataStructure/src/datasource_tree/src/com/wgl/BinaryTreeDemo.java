package datasource_tree.src.com.wgl;

/**
 * @author 万葛亮
 * @Date 2020 07 24 19:58
 * @GIRL friend 江珊
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "武松");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "姜子牙");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(node1);
//        tree.preOrder();
//        tree.midOrder();
//        tree.postOrder();
//        HeroNode resNode = tree.preSearch(5);
//        System.out.println("前序遍历查找结果为：" + resNode);
//        HeroNode resNode1 = tree.midSearch(5);
//        System.out.println("中序遍历查找结果为：" + resNode1);
//        HeroNode resNode12 = tree.postSearch(5);
//        System.out.println("后序遍历查找结果为：" + resNode12);
        tree.delNode(3);
        tree.preOrder();
    }
}

class BinaryTree {
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            System.out.println("前序遍历结果：");
            this.root.preOrder();
        } else {
            System.out.println("二叉树的数据有误，无法遍历");
        }

    }

    //中序遍历
    public void midOrder() {
        if (this.root != null) {
            System.out.println("中序遍历结果：");
            this.root.midOrder();
        } else {
            System.out.println("二叉树的数据有误，无法遍历");
        }

    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            System.out.println("后序遍历结果：");
            this.root.postOrder();
        } else {
            System.out.println("二叉树的数据有误，无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preSearch(int id) {
        HeroNode resNode = null;
        if (this.root != null) {
            resNode = this.root.preSearch(id);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode midSearch(int id) {
        HeroNode resNode = null;
        if (this.root != null) {
            resNode = this.root.midSearch(id);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postSearch(int id) {
        HeroNode resNode = null;
        if (this.root != null) {
            resNode = this.root.postSearch(id);
        }
        return resNode;
    }

    public void delNode(int id) {
        if (root!=null){
            if (root.getId()==id){
                root=null;
            }else {
                root.delNode(id);
            }
        }else {
            System.out.println("二叉树是空树，无法遍历~~~");
        }
    }
}

class HeroNode {
    private int id;
    private String name;
    private HeroNode left;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    private HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preSearch(int id) {
        HeroNode resNode = null;
        System.out.println("进入前序遍历查找~~~");
        if (this.id == id) {
            return this;
        }
        if (this.left != null) {
            resNode = this.left.preSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preSearch(id);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode midSearch(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.midSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序遍历查找~~~");
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.midSearch(id);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postSearch(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序遍历查找~~~");
        if (this.id == id) {
            return this;
        }
        return resNode;
    }

    //删除节点
    public void delNode(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(id);
        }
        if (this.right!=null){
            this.right.delNode(id);
        }
    }
}
