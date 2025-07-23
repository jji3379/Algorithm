import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(findMin(a, k));
    }

    private static int findMin(int a, int k) {
        if (a == k) {
            return 0;
        }

        int[] distance = new int[k + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        Arrays.fill(distance, -1);
        distance[a] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == k) {
                return distance[k];
            }

            int add = current + 1;
            int multiple = current * 2;

            if (add == k || multiple == k) {
                return distance[current] + 1;
            }

            if (add <= k && distance[add] == -1) {
                distance[add] = distance[current] + 1;
                queue.add(add);
            }

            if (multiple <= k && distance[multiple] == -1) {
                distance[multiple] = distance[current] + 1;
                queue.add(multiple);
            }
        }

        return -1;
    }
}
