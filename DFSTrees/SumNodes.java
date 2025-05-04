package DFSTrees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SumNodes {

    static int maxDepth = 0;
    static int sum = 0;
    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \     \
            4   5     8
                     / \
                    6   7
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        // Aquí llama a tu función y muestra el resultado
        int resultado = deepestLeavesSum(root);
        System.out.println("Suma de nodos en el nivel más profundo: " + resultado);
    }

    private static int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode node, int depth) {
        if(node == null) return;

        if(depth > maxDepth) {
            maxDepth = depth;
            sum = node.val;
        }
        //if its the maximum level
        else if(depth == maxDepth) {
            sum += node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
