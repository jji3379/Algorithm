import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15486
 */
public class NO_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n + 1];
        int[] prices = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            times[i] = t;
            prices[i] = p;
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int time = times[i];
            int price = prices[i];

            int endTime = i + time - 1;
            if (endTime <= n) {
                dp[endTime] = Math.max(dp[endTime], dp[i - 1] + price);
            }

            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}
