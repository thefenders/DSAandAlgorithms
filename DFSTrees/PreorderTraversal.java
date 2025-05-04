package DFSTrees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PreorderTraversal { 
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        prinPreorder(root);
    }

    private static void prinPreorder(TreeNode root) {
        if(root == null) return;

        System.out.print(root.val + " ");
        prinPreorder(root.left);
        prinPreorder(root.right);
    }
}
