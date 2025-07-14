import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] number = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            number[i][0] = Integer.parseInt(st.nextToken());
            number[i][1] = Integer.parseInt(st.nextToken());
            number[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] maxDP = new int[n + 1][3];
        int[][] minDP = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            maxDP[i][0] += Math.max(maxDP[i-1][0], maxDP[i-1][1]) + number[i][0];
            minDP[i][0] += Math.min(minDP[i-1][0], minDP[i-1][1]) + number[i][0];

            maxDP[i][1] += Math.max(Math.max(maxDP[i - 1][0], maxDP[i - 1][1]), maxDP[i - 1][2]) + number[i][1];
            minDP[i][1] += Math.min(Math.min(minDP[i - 1][0], minDP[i - 1][1]), minDP[i - 1][2]) + number[i][1];

            maxDP[i][2] += Math.max(maxDP[i-1][2], maxDP[i-1][1]) + number[i][2];
            minDP[i][2] += Math.min(minDP[i-1][2], minDP[i-1][1]) + number[i][2];
        }

        int maxValue = Math.max(Math.max(maxDP[n][0], maxDP[n][1]), maxDP[n][2]);
        int minValue = Math.min(Math.min(minDP[n][0], minDP[n][1]), minDP[n][2]);

        System.out.println(maxValue + " " + minValue);
    }
}
