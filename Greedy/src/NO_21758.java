import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21758
 */
public class NO_21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] honey = new int[n];

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            honey[i] = value;
        }

        int[] prefix = new int[n];
        prefix[0] = honey[0];

        // 누적합
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + honey[i];
        }

        int max = 0;
        // 벌 - 벌 - 벌통
        for (int bee2Pos = 1; bee2Pos < n - 1; bee2Pos++) {
            int totalSum = prefix[n - 1];
            int bee1 = totalSum - honey[0] - honey[bee2Pos];
            int bee2 = totalSum - prefix[bee2Pos];

            max = Math.max(max, bee1 + bee2);
        }

        // 벌통 - 벌 - 벌
        for (int bee1Pos = 1; bee1Pos < n - 1; bee1Pos++) {
            int bee1 = prefix[bee1Pos - 1];
            int bee2 = prefix[n - 2] - honey[bee1Pos];
            
            max = Math.max(max, bee1 + bee2);
        }

        // 벌 - 벌통 - 벌
        for (int hivePos = 1; hivePos < n - 1; hivePos++) {
            int bee1 = prefix[hivePos] - honey[0];
            int bee2 = prefix[n - 2] - prefix[hivePos - 1];

            max = Math.max(max, bee1 + bee2);
        }

        System.out.print(max);
    }
}
