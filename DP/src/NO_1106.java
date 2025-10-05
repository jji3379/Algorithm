import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1106
 */
public class NO_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] costs = new int[n];
        int[] users = new int[n];



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int user = Integer.parseInt(st.nextToken());

            costs[i] = cost;
            users[i] = user;
        }

        int[] dp = new int[c + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int cost = costs[i];
            int user = users[i];

            for (int j = user; j < c + 101; j++) {
                if (dp[j - user] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - user] + cost, dp[j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = c; i < c + 101; i++) {
            result = Math.min(result, dp[i]);
        }

        System.out.print(result);
    }
}
