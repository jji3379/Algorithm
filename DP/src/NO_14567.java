import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14567
 */
public class NO_14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int subject = Integer.parseInt(st.nextToken());

            tree[subject].add(pre);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            List<Integer> subject = tree[i];

            for (int j = 0; j < subject.size(); j++) {
                int pre = subject.get(j);
                dp[i] = Math.max(dp[pre] + 1, dp[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
