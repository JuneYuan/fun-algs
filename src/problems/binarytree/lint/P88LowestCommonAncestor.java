package problems.binarytree.lint;

import java.util.*;

public class P88LowestCommonAncestor {
    List<Deque<TreeNode>> paths = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    Deque<TreeNode> stack = new ArrayDeque<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        dfs(root);

        Deque<TreeNode> pathA = null, pathB = null;
        for (Deque<TreeNode> path : paths) {
            if (pathA == null && path.contains(A)) {
                pathA = path;
            }

            if (pathB == null && path.contains(B)) {
                pathB = path;
            }

            if (pathA != null && pathB != null) {
                break;
            }
        }

        TreeNode result = null;

        if (pathA.equals(pathB)) {
            while (!(result = pathA.peek()).equals(A) && !result.equals(B)) {
                pathA.poll();
            }
            return result;
        }

        TreeNode peekA, peekB;
        while ((peekA = pathA.peek()) != null && (peekB = pathB.peek()) != null && peekA.equals(peekB)) {
            result = pathA.poll();
            pathB.poll();
        }
        return result;
    }

    /**
     * A tough dfs implementation...
     */
    public void dfs(TreeNode root) {
        stack.push(root);

        // 8 5 1
        if (root.left != null) {
            dfs(root.left);
        } else if (root.right != null) {
            dfs(root.right);
        }

        // 快照一下当前路径：[8 5 1] [8 5 4 2] [8 5 4 3] [8 7 6]
        if (!stack.isEmpty()) {
            savePath(stack);
        } else {
            return;
        }

        // 叶子结点出栈
        TreeNode t = stack.poll();
        visited.add(t);

        //
        TreeNode peek = stack.peek();
        while (peek != null && (peek.right == null || visited.contains(peek.right))) {
            t = stack.poll();
            visited.add(t);
            peek = stack.peek();
        }

        // dfs(4) dfs(3)
        if (peek != null) {
            dfs(peek.right);
        }
    }

    private void savePath(Deque<TreeNode> stack) {
        Deque<TreeNode> onePath = new ArrayDeque<>();

        Iterator<TreeNode> it = stack.iterator();
        while (it.hasNext()) {
            onePath.push(it.next());
        }

        paths.add(onePath);
    }


    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[8];
        int[] values = new int[]{8, 5, 7, 1, 4, 6, 2, 3};
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(values[i]);
        }

        // case I
        nodes[0].left = nodes[1];  nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];  nodes[1].right = nodes[4];
        nodes[2].left = null;      nodes[2].right = nodes[5];
        nodes[4].left = nodes[6];  nodes[4].right = nodes[7];

        // case II
        nodes[0].left = nodes[1];  nodes[0].right = null;
        nodes[1].left = null;      nodes[1].right = null;

        P88LowestCommonAncestor instance = new P88LowestCommonAncestor();
        TreeNode lca = instance.lowestCommonAncestor(nodes[0], nodes[0], nodes[1]);
        System.out.println(lca.val);
    }

}

class DFS2 {
    Deque<TreeNode> stack = new ArrayDeque<>();
    Deque<TreeNode> pathA, pathB;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        helper(root, A, B);

        TreeNode result = null;
        while (!pathA.isEmpty() && !pathB.isEmpty() && pathA.peek().equals(pathB.peek())) {
            result = pathA.poll();
            pathB.poll();
        }

        return result;
    }

    private void helper(TreeNode root, TreeNode A, TreeNode B) {
        stack.push(root);

        if (root == A) {
            pathA = cpPath(stack);
        }
        if (root == B) {
            pathB = cpPath(stack);
        }

        if (root.left != null) {
            helper(root.left, A, B);
        }

        if (root.right != null) {
            helper(root.right, A, B);
        }

        stack.pop();
    }

    private Deque<TreeNode> cpPath(Deque<TreeNode> stack) {
        Deque<TreeNode> route = new ArrayDeque<>();

        Iterator<TreeNode> it = stack.iterator();
        while (it.hasNext()) {
            route.push(it.next());
        }

        return route;
    }

    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[2];
        int[] values = new int[]{2, -1};
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(values[i]);
        }

        // case I
        nodes[0].left = nodes[1];  nodes[0].right = null;
        nodes[1].left = null;      nodes[1].right = null;

        DFS2 instance = new DFS2();
        TreeNode lca = instance.lowestCommonAncestor(nodes[0], nodes[1], nodes[0]);
        System.out.println(lca.val);
    }

}