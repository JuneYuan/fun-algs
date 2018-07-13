package leetcode1st.binarySearchTree;

public class PxBst2LinkedList {

    public static void solve(Node n) {
        if (n == null) {
            return;
        }
        if (n.left == null && n.right == null) {
            return;
        }
        dfsMax(n, null);
    }

    public static Node dfsMax(Node n, Node lf) {
        // 处理左子树（相当于确定了n的前驱）
        Node ls = null;
        if (n.left != null) {
            ls = dfsMax(n.left, lf);
        }

        // 建立关系
        Node prev = (ls != null) ? ls : lf;
        n.left = prev;
        if (prev != null) {
            prev.right = n;
        }

        // 处理右子树（相当于确定了返回值）
        Node rs = null;
        if (n.right != null) {
            rs = dfsMax(n.right, n);
        }
        return (rs != null) ? rs : n;
    }

    // yesterday
    public static Node dfs(Node n, Node lf) {
        Node x = null;
        if (n.left != null) {
            x = dfs(n.left, lf);
        }
        Node pre = (x != null) ? x : lf;
        n.left = pre;
        if (pre != null) {
            pre.right = n;
        }

        Node y = null;
        if (n.right != null) {
            y = dfs(n.right, n);
        }
        return (y != null) ? y : n;
    }



    private static Node case1() {
        int N = 7;
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        nodes[0].right = nodes[1];
        nodes[1].right = nodes[2];
        nodes[2].right = nodes[3];
        nodes[3].right = nodes[4];
        nodes[4].right = nodes[5];
        nodes[5].right = nodes[6];

        return nodes[0];
    }

    private static Node case2() {
        int N = 7;
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(N - i);
        }

        nodes[0].left = nodes[1];
        nodes[1].left = nodes[2];
        nodes[2].left = nodes[3];
        nodes[3].left = nodes[4];
        nodes[4].left = nodes[5];
        nodes[5].left = nodes[6];

        return nodes[0];
    }

    private static Node case3() {
        int N = 7;
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        nodes[4].left = nodes[1];
        nodes[4].right = nodes[5];
        nodes[5].right = nodes[6];
        nodes[1].left = nodes[0];
        nodes[1].right = nodes[3];
        nodes[3].left = nodes[2];

        return nodes[4];
    }

    private static void printResult(Node n) {
        Node start = n;
        while (start.left != null) {
            start = start.left;
        }

        StringBuilder sb = new StringBuilder();
        do {
            sb.append(start.value);
            if (start.right != null) {
                sb.append(", ");
            }
            start = start.right;
        } while (start != null);

        System.out.println(sb);
    }

    public static void main(String[] args) {
        Node n = case1();
        solve(n);
        printResult(n);

        n = case2();
        solve(n);
        printResult(n);

        n = case3();
        solve(n);
        printResult(n);
    }

}

class Node {
    int value;
    public Node left, right;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
