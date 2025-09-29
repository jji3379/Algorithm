import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3584
 */
public class NO_3584 {
    private static int[] childTree;
    private static boolean[] visited;
    private static int sameRoot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            childTree = new int[n + 1];
            visited = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (j != n - 1) {
                    childTree[b] = a;
                } else {
                    findRoot(a);
                    findSameRoot(b);

                    System.out.println(sameRoot);
                }
            }
        }
    }

    private static void findRoot(int node) {
        visited[node] = true;

        int root = childTree[node];

        if (root != 0) {
            findRoot(root);
        }
    }

    private static void findSameRoot(int node) {
        if (visited[node]) {
            sameRoot = node;
        } else {
            int root = childTree[node];
            findSameRoot(root);
        }
    }
}
