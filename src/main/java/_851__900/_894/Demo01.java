package _851__900._894;

import _51__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(allPossibleFBT(7));
        System.out.println(allPossibleFBT(1));
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(0);
        dfs(root, list, Collections.singletonList(root), n - 1);
        return list;
    }

    private void dfs(TreeNode root, List<TreeNode> list, List<TreeNode> endpoints, int n) {
        if (n == 0) {
            list.add(root);
            return;
        }
        for (TreeNode node : endpoints) {
            List<TreeNode> copiedEndpoints = new ArrayList<>();
            TreeNode copy = copy(root, copiedEndpoints, node);
            int idx = 0;
            for (int i = 0; i < copiedEndpoints.size(); i++) {
                if (copiedEndpoints.get(i) == node) {
                    idx = i;
                    break;
                }
            }
            dfs(copy, list, copiedEndpoints.subList(idx + 1, copiedEndpoints.size()), n - 2);
        }
    }

    private TreeNode copy(TreeNode root, List<TreeNode> endpoints, TreeNode pre) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        if (root == pre) {
            node.left = new TreeNode(0);
            node.right = new TreeNode(0);
            endpoints.add(pre);
            endpoints.add(node.left);
            endpoints.add(node.right);
        } else {
            if (root.left == null && root.right == null) endpoints.add(node);
            node.left = copy(root.left, endpoints, pre);
            node.right = copy(root.right, endpoints, pre);
        }
        return node;
    }

}