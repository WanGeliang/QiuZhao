package datasource_binarySortTree.src;

/**
 * @author 万葛亮
 * @Date 2020 08 02 16:17
 * @GIRL friend 江珊
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            binaryTree.addNode(new Node(arr[i]));
        }
        binaryTree.midOrder();
//        Node curNode = binaryTree.getCurNode(5);
//        System.out.println(curNode);
//        Node parentNode = binaryTree.getParentNode(5);
//        System.out.println(parentNode);
        binaryTree.delNode(2);
        binaryTree.delNode(5);
        binaryTree.delNode(9);
        binaryTree.delNode(12);
        binaryTree.delNode(7);
        binaryTree.delNode(3);
//        System.out.println("root=" + binaryTree.root);
//        System.out.println(binaryTree.getParentNode(1));
        binaryTree.delNode(1);
        binaryTree.delNode(10);
        System.out.println();
        binaryTree.midOrder();
//        System.out.println();
//        Node root = binaryTree.root;
//        System.out.println(root);

    }
}

class BinaryTree {
    public Node root;

    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    //获取需要被删除的结点
    public Node getCurNode(int value) {
        if (root != null) {
            return root.getCurNode(value);
        } else {
            return null;
        }
    }

    //获取删除结点的父节点
    public Node getParentNode(int value) {
        if (root != null) {
            return root.getParentNode(value);
        } else {
            return null;
        }
    }

    /**
     * 传入的待删除结点的右结点
     * 将此右结点作为根节点查找最小的value值
     *
     * @param node
     * @return
     */
    public int getRightTreeMin(Node node) {
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        delNode(temp.value);
        return temp.value;
    }

    /**
     * 传入的待删除结点的右结点
     * 将此右结点作为根节点查找最小的value值
     *
     * @param node
     * @return
     */
    public int getLeftTreeMax(Node node) {
        Node temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        delNode(temp.value);
        return temp.value;
    }

    /**
     * 删除结点
     *
     * @param value
     */
    public void delNode(int value) {

        if (root == null) {
            return;
        }
        Node targetNode = getCurNode(value);
        if (targetNode == null) {
            return;
        }
        if (targetNode.left == null && targetNode.right == null && root.value == targetNode.value) {//当前结点就是root结点
            root = null;
            return;
        }
        Node parentNode = getParentNode(value);
 /*       if (parentNode == null) {
            if (root.left == null && root.right == null && root.value == value) {
                root = null;
                return;
            }
            if (root.left != null && root.right == null && root.value == value) {
                root = root.left;
                return;
            }
            if (root.left == null && root.right != null && root.value == value) {
                root = root.right;
                return;
            }
        }

  */
        if (targetNode.left == null && targetNode.right == null) {//删除叶子结点
            if (parentNode.left != null && parentNode.left.value == value) {
                parentNode.left = null;
            } else if (parentNode.right != null && parentNode.right.value == value) {
                parentNode.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {//删除具有两颗子树的结点
//            int rightTreeMin = getRightTreeMin(targetNode.right);
//            targetNode.value = rightTreeMin;
            int leftTreeMax = getLeftTreeMax(targetNode.left);
            targetNode.value = leftTreeMax;
        } else {//删除只有一个叶子结点的结点
            if (targetNode.left != null) {//刪除的结点存在左结点
                if (parentNode != null) {//判断一棵树存在父节点为空的情况
                    if (parentNode.left.value == value) {//删除的结点是父节点的左子结点
                        parentNode.left = targetNode.left;
                    } else {//删除的结点是父节点的右子结点
                        parentNode.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
            } else {//刪除的结点存在右结点
                if (parentNode != null) {//判断一棵树存在父节点为空的情况
                    if (parentNode.left.value == value) {//删除的结点是父节点的左子结点
                        parentNode.left = targetNode.right;
                    } else {//删除的结点是父节点的右子结点
                        parentNode.right = targetNode.right;
                    }
                }else {
                    root=targetNode.right;
                }
            }
        }
    }

    public void midOrder() {
        if (root != null) {
            root.midOrder();
        } else {
            System.out.println("二叉排序树为空~~~~");
        }
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //先写一个二叉排序树
    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }

    }

    /**
     * 查詢需要刪除的结点
     *
     * @param value
     * @return
     */
    public Node getCurNode(int value) {
        if (this.value == value) {
            return this;
        }
        if (this.value > value && this.left != null) {
            return this.left.getCurNode(value);
        } else if (this.value <= value && this.right != null) {
            return this.right.getCurNode(value);
        } else {
            return null;
        }

    }

    /**
     * 查询需要删除结点的父结点
     *
     * @return
     */
    public Node getParentNode(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else if (value < this.value && this.left != null) {
            return this.left.getParentNode(value);
        } else if (value >= this.value && this.right != null) {
            return this.right.getParentNode(value);
        } else {
            return null;
        }
    }

    //写一个中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }
}