import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1806
 */
public class NO_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int sum = arr[0];
        int result = Integer.MAX_VALUE;

        if (sum >= s) {
            result = 1;
        }

        int temp = 1;
        for (int i = 1; i < n; i++) {
            int rt = i;
            int rightValue = arr[rt];

            temp++;

            sum = sum + rightValue;

            if (sum < s) {
                rt++;
            } else {
                while (lt < rt) {
                    if (sum < s) {
                        break;
                    }

                    int leftValue = arr[lt];
                    result = Math.min(result, temp);
                    sum = sum - leftValue;
                    temp--;
                    lt++;
                }

                if (lt == rt && sum >= s) {
                    result = 1;
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
