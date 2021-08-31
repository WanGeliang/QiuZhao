package datasource_tree.src.com.wgl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 万葛亮
 * @Date 2020 07 29 22:53
 * @GIRL friend 江珊
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        HupreOrder(root);
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Node(arr[i]));
        }
        while (list.size() > 1) {
            Collections.sort(list);
//            System.out.println(list);
//        System.out.println(list);
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node newNode=new Node(leftNode.val+rightNode.val);
            newNode.leftNode=leftNode;
            newNode.rightNode=rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(newNode);
        }
       return (list.get(0));
    }
    public static void HupreOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else {
            System.out.println("霍夫曼树为空~~~");
        }
    }
}

class Node implements Comparable<Node> {
    public int val;
    public Node leftNode;
    public Node rightNode;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public void preOrder() {
        System.out.print(this.val+"->");
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }

    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}