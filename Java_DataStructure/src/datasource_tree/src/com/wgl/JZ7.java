package datasource_tree.src.com.wgl;

import java.util.HashMap;
import java.util.Map;

public class JZ7 {
    public static void main(String[] args) {

    }

    public TreeNode builderTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public TreeNode help(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {

        if (preStart == preEnd || inStart == inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        //从map中获取根节点的下标
        int index = map.get(root.val);
        //开始构建左子树
        root.left = help(preorder, preStart + 1, preStart + index + 1, inorder, inStart, index, map);
        root.right = help(preorder, preStart + index + 1, preEnd, inorder, index + 1, inEnd, map);
        return root;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}
