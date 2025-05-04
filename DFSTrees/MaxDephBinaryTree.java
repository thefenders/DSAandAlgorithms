package DFSTrees;

public class MaxDephBinaryTree {
       // Definición del nodo del árbol binario
       static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Main para construir el árbol y probar tu función
    public static void main(String[] args) {
        /*
            Ejemplo de árbol:
                    3
                   / \
                  9  20
                     / \
                    15  7
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maxDepth(root); 
        System.out.println("Maximum depth: " + depth);
    }

    private static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
    
}
