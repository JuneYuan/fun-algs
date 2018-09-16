package problems.binarytree.leet.twice;

import java.util.*;

/**
 * 蠢蠢的老实的解法：预处理好一个map用来记录每个节点及其对应的高度，然后依照定义递归求解。
 * 预处理函数{@link #processDepthMap}也是递归实现，由{@link P104MaximumDepthOfBinaryTree}简单变化而来。
 */
public class P110BalancedBinaryTree {
    Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();

    {
        nodeDepthMap.put(null, 0);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        processDepthMap(root);

        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        int lDepth = nodeDepthMap.get(root.left), rDepth = nodeDepthMap.get(root.right);
        if (lDepth <= 1 && rDepth <= 1) {
            return true;
        }

        if (Math.abs(lDepth - rDepth) > 1) {
            return false;
        }

        return helper(root.left) && helper(root.right);
    }

    private int processDepthMap(TreeNode root) {
        if (root == null) {
            nodeDepthMap.put(null, 0);
            return 0;
        }

        if (root != null && root.left == null && root.right == null) {
            nodeDepthMap.put(root, 1);
            return 1;
        }

        int lDepth = processDepthMap(root.left), rDepth = processDepthMap(root.right);
        int currDepth = Math.max(lDepth, rDepth) + 1;
        nodeDepthMap.put(root, currDepth);
        return currDepth;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b0 = new TreeNode(20);
        TreeNode b1 = new TreeNode(21);
        TreeNode c0 = new TreeNode(30);
        TreeNode c1 = new TreeNode(31);
        TreeNode d0 = new TreeNode(40);
        TreeNode d1 = new TreeNode(41);
        TreeNode e0 = new TreeNode(50);
        TreeNode e1 = new TreeNode(51);

        a.left = b0;  a.right = b1;
        b0.left = c0;  b0.right = c1;
        c0.left = d0;  c0.right = d1;
        d0.left = e0;  d0.right = e1;

        Solution2 s = new Solution2();
        System.out.println(s.isBalanced(a));
        System.out.println(s.lVals);
    }

}

class Simpler {
    Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();
    Map<TreeNode, Boolean> nodeBalancedMap = new HashMap<>();

    {
        nodeDepthMap.put(null, 0);
    }

    public boolean isBalanced(TreeNode root) {
        return false;
    }

    private int processDepthMap(TreeNode root) {
        // process both nodeDepthMap and nodeBalancedMap
        return 0;
    }
}

class HodorSln {
    void isB(TreeNode root) {
        if (root == null) {
            return;
        }
        isB(root.left); // 求left的信息
        isB(root.right); // 求right的信息
        root.isB = true;
        root.dep = 0;
        int ldep = 0, rdep = 0;
        if (root.left != null) {
            ldep = root.left.dep;
            if (!root.left.isB) root.isB = false;
            if (root.left.dep + 1 > root.dep) root.dep = root.left.dep + 1;
        }
        if (root.right != null) {
            rdep = root.right.dep;
            if (!root.right.isB) root.isB = false;
            if (root.right.dep + 1 > root.dep) root.dep = root.right.dep + 1;
        }
        if (Math.abs(ldep - rdep) > 1) {
            root.isB = false;
        }
    }
}

/**
 * improved version of "蠢蠢的老实的解法"
 */
class Solution2 {
    Set<Integer> lVals = new HashSet<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null)   return true;

        int lHeight = height(root.left, 1), rHeight = height(root.right, 1);
        if (Math.abs(lHeight - rHeight) > 1)    return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * @param root the node whose height to be solved
     * @param h 当前递归到的节点，与最开始求height的节点，二者的"距离"，初始值为1
     * @return the height
     */
    private int height(TreeNode root, int h) {
        lVals.add(h);

        if (root == null)   return h;
        if (root.left == null && root.right == null)    return h + 1;
        if (root.left == null)  {
            return height(root.right, h + 1);
        }
        if (root.right == null)  {
            return height(root.left, h + 1);
        }

        int x = height(root.left, h + 1);
        int y = height(root.right, h + 1);
        return Math.max(x, y);
    }
}

/**
 * a more delicate solution
 */
class Solution3 {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)   return 0;

        int lDepth = maxDepth(root.left), rDepth = maxDepth(root.right);
        if (lDepth == -1 || rDepth == -1 || Math.abs(lDepth - rDepth) > 1) {
            return -1;
        }

        return 1 + Math.max(lDepth, rDepth);
    }
}
