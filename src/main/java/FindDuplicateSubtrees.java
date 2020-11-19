import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {


    //https://leetcode.com/problems/find-duplicate-subtrees/
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<TreeNode> root = new FindDuplicateSubtrees().findDuplicateSubtrees(
                new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(3, new TreeNode(2), new TreeNode(4))));


        //1,2,3,4,null,2,4,null,null,4
        for (TreeNode node : root) {
            System.out.println(node.val);
            sb = new StringBuilder();
            traversePreOrder(sb, node);
            System.out.println(sb);
        }
    }

    public static void traversePreOrder(StringBuilder sb, TreeNode node) {
        if (node != null) {
            traversePreOrder(sb, node.left);
            sb.append("," + node.val + ",");
            traversePreOrder(sb, node.right);
        } else
            sb.append("null");
    }

    List<TreeNode> res = new LinkedList<>();
    Map<String, Integer> map = new HashMap<String, Integer>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traversePreOrder(root);
        return res;
    }

    public String traversePreOrder(TreeNode node) {
        if (node != null) {
            String sb = node.val + "," + traversePreOrder(node.left) + "," + traversePreOrder(node.right);
            System.out.println(sb);
            if (map.getOrDefault(sb, 0) == 1) res.add(node);
            map.put(sb, map.getOrDefault(sb, 0) + 1);
            return sb;
        } else
            return "X";
    }
}
