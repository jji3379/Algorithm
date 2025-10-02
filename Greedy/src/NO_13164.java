import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13164
 */
public class NO_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> talls = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            talls.add(value);
        }

        List<Integer> costs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int cost = Math.abs(talls.get(i) - talls.get(i + 1));
            costs.add(cost);
        }

        Collections.sort(costs);

        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += costs.get(i);
        }

        System.out.print(result);
    }
}
