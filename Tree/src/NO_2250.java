import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2250
 */
public class NO_2250 {
    private static class Node {
        private int num;
        private int parent;
        private int left;
        private int right;

        private Node(int num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
            this.parent = -1;
        }
    }

    private static int maxLevel;
    private static int index;
    private static Node[] tree;
    private static int[] max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new Node[n + 1];
        max = new int[n + 1];
        min = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new Node(i, -1, -1);
            max[i] = 0;
            min[i] = n + 1;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[num].left = left;
            tree[num].right = right;

            if (left > 0) {
                tree[left].parent = num;
            }

            if (right > 0) {
                tree[right].parent = num;
            }
        }

        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (tree[i].parent == -1) {
                root = i;
            }
        }

        index = 1;
        maxLevel = 0;
        inOrder(root, 1);

        int resultLevel = 0;
        int resultWidth = 0;

        for (int i = 1; i <= maxLevel; i++) {
            int width = max[i] - min[i] + 1;
            if (resultWidth < width) {
                resultLevel = i;
                resultWidth = width;
            }
        }

        System.out.println(resultLevel + " " + resultWidth);
    }

    private static void inOrder(int num, int level) {
        Node node = tree[num];

        // left
        if (node.left > 0) {
            inOrder(node.left, level + 1);
        }

        // root
        maxLevel = Math.max(maxLevel, level);
        max[level] = Math.max(max[level], index);
        min[level] = Math.min(min[level], index);
        index++;

        // right
        if (node.right > 0) {
            inOrder(node.right, level + 1);
        }
    }
}
