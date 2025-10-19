import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/15961
 */
public class NO_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[n];
        int[] check = new int[d + 1];

        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int result = 1;
        check[c]++;

        for (int i = 0; i < k; i++) {
            if (check[belt[i]] == 0) {
                result++;
            }

            check[belt[i]]++;
        }

        int count = result;
        for (int i = 1; i < n; i++) {
            int pop = belt[i - 1];
            check[pop]--;

            if (check[pop] == 0) {
                count--;
            }

            int add = belt[(i + k - 1) % n];
            if (check[add] == 0) {
                count++;
            }

            check[add]++;

            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}
