package DFSTrees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InorderTraversal {
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        printInorder(root);
    }

    private static void printInorder(TreeNode root) {
        /*
         * Algorithm:
         * 1 If the root is NULL =, return
         * 2 Recursively traverse the left subtree
         * 3 Process the current node, the root node, i.e print it
         * 4 Recursively traverse the right subtree 
         */
        if(root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

//Timey Complexity: O(n) where n is the total number of nodes
//Auxiliary space: O(h) where h is the height of the tree 
// In the worse case, h can be the same as N (when the tree is a skewed tree)
// In the best case, h can be the same as log N (when tree is a complete tree)