import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_20924 {
    private static class Node {
        private int vertex;
        private int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private static boolean[] visited;
    private static int root;
    private static int n;
    private static List<Node>[] tree;
    private static int giga;
    private static int maxLeafLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            tree[a].add(new Node(b, d));
            tree[b].add(new Node(a, d));
        }

        int height = findHeight(root, 0);
        int maxLeafLength = findMaxLeafLength(giga, 0);

        System.out.println(height + " "+ maxLeafLength);
    }

    private static int findHeight(int edge, int leafLength) {
        visited[edge] = true;

        if (leafCount(edge) != 1) {
            giga = edge;
            return leafLength;
        } else {
            for (Node node : tree[edge]) {
                int nextVertex = node.vertex;

                if (!visited[nextVertex]) {
                    int distance = node.distance;
                    int totalLength = leafLength + distance;

                    return findHeight(nextVertex, totalLength);
                }
            }
        }

        return -1;
    }

    private static int findMaxLeafLength(int edge, int length) {
        if (leafCount(edge) == 0) {
            return length;
        }

        for (Node node : tree[edge]) {
            int nextVertex = node.vertex;

            if (!visited[nextVertex]) {
                visited[nextVertex] = true;
                int treeHeight = length + node.distance;

                maxLeafLength = Math.max(maxLeafLength, findMaxLeafLength(nextVertex, treeHeight));
            }
        }

        return maxLeafLength;
    }

    private static int leafCount(int edge) {
        int count = 0;
        for (Node next : tree[edge]) {
            if (!visited[next.vertex]) {
                count++;
            }
        }

        return count;
    }
}
