import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22856
 */
public class NO_22856 {
    private static boolean[] visited;
    private static int[] left, right;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        left = new int[n + 1];
        right = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            int leftValue = Integer.parseInt(st.nextToken());
            int rightValue = Integer.parseInt(st.nextToken());

            left[current] = leftValue;
            right[current] = rightValue;
        }

        System.out.println(2 * (n - 1) - findEnd(1, 0));
    }

    static int findEnd(int current, int depth) {
        if (right[current] != -1) {
            return findEnd(right[current], depth + 1);
        }

        return depth;
    }
}
