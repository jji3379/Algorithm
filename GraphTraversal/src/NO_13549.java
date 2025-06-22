import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_13549 {
    static int k;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void bfs(int value) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(value, 0));
        visited[value] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // end 조건
            if (current.x == k) {
                min = Math.min(min, current.time);
            }

            // 순간이동
            if (current.x * 2 <= 100_000 && !visited[current.x * 2]) {
                queue.offer(new Node(current.x * 2, current.time));
                visited[current.x * 2] = true;
            }

            // X -1
            if (current.x - 1 >= 0 && !visited[current.x - 1]) {
                queue.offer(new Node(current.x - 1, current.time + 1));
                visited[current.x - 1] = true;
            }

            // X + 1
            if (current.x + 1 <= 100_000 && !visited[current.x + 1]) {
                queue.offer(new Node(current.x + 1, current.time + 1));
                visited[current.x + 1] = true;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bfs(n);

        System.out.println(min);
    }
}
