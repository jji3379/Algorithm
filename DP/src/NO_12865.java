import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12865
 */
public class NO_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            w[i] = weight;
            v[i] = value;
        }


        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int wi = w[i];
            int vi = v[i];

            for (int j = k; j >= wi; j--) {
                dp[j] = Math.max(dp[j], dp[j - wi] + vi);
            }
        }

        System.out.print(dp[k]);
    }
}
