import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2758
 */
public class NO_2758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 고르는 수 <= 10
            int n = Integer.parseInt(st.nextToken());

            // m 까지의 수 <= 2,000
            int m = Integer.parseInt(st.nextToken());

            long[][] dp = new long[n + 1][m + 1];

            for (int k = 0; k <= m; k++) {
                dp[0][k] = 1L;
            }

            for (int num = 1; num <= n; num++) {
                for (int max = 1; max <= m; max++) {
                    // max 값 사용하는 경우 (n-1 개 더 필요), max 안 쓰는 경우 (n 개 필요)
                    dp[num][max] = dp[num - 1][max / 2] + dp[num][max - 1];
                }
            }

            System.out.println(dp[n][m]);
        }
    }
}
