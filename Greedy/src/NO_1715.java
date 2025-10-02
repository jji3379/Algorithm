import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1715
 */
public class NO_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> qp = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long card = Integer.parseInt(br.readLine());
            qp.offer(card);
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
