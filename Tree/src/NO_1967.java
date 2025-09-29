import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1967
 */

public class NO_1967 {
    private static class Node {
        private int vertex;
        private int value;

        private Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }

    private static int maxLength;
    private static boolean[] visited;
    private static List<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            tree[root].add(new Node(child, value));
            tree[child].add(new Node(root, value));
        }


        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            findMaxLength(i, 0);
        }

        System.out.println(maxLength);
    }

    private static void findMaxLength(int root, int length) {
        for (Node node : tree[root]) {
            int vertex = node.vertex;

            if (!visited[vertex]) {
                int totalLength = node.value + length;

                maxLength = Math.max(maxLength, totalLength);

                visited[vertex] = true;
                findMaxLength(vertex, totalLength);
            }
        }
    }
}
