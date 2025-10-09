import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5557
 */
public class NO_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }

        long[][] dp = new long[n][21];

        dp[0][arr[0]] = 1;

        int plus = 0;
        int minus = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                plus = j + arr[i];
                minus = j - arr[i];

                if (plus >= 0 && plus <= 20) {
                    dp[i][plus] += dp[i - 1][j];
                }

                if (minus >= 0 && minus <= 20) {
                    dp[i][minus] += dp[i - 1][j];
                }
            }
        }

        System.out.print(dp[n - 2][arr[n - 1]]);
    }
}
