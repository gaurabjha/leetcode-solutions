//https://leetcode.com/problems/delete-leaves-with-a-given-value/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}

public class TreeNodeDelete {

    //https://leetcode.com/problems/delete-leaves-with-a-given-value/submissions/

    public static void main(String[] args) {

        //[1,2,3,2,null,2,4]

        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, new TreeNodeDelete().removeLeafNodes(
                new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(3, new TreeNode(2), new TreeNode(4))), 2)
        );
        System.out.println(sb.toString());
    }

    public static void traversePreOrder(StringBuilder sb, TreeNode node) {
        if (node != null) {
            sb.append(node.val);
            sb.append("\n");
            traversePreOrder(sb, node.left);
            traversePreOrder(sb, node.right);
        } else
            sb.append("n\n");
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target)
            return null;
        return root;
    }

}


