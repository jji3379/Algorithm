import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] minCount = new int[n];
        Arrays.fill(minCount, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        minCount[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            if (minCount[i] != Integer.MAX_VALUE) {
                for (int j = i; j <= i + arr[i]; j++) {
                    if (j < n) {
                        minCount[j] = Math.min(minCount[j], minCount[i] + 1);
                    }
                }
            }
        }

        if (minCount[n - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCount[n - 1]);
        }
    }
}
