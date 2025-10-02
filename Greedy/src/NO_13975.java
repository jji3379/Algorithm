import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13975
 */
public class NO_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> qp = new PriorityQueue<>();

            for (int j = 0; j < n; j++) {
                long value = Integer.parseInt(st.nextToken());
                qp.offer(value);
            }

            long result = 0L;

            while (qp.size() > 1) {
                Long value1 = qp.poll();
                Long value2 = qp.poll();

                long sum = value1 + value2;
                result += sum;

                qp.offer(sum);
            }

            System.out.println(result);
        }
    }
}
