import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/7453
 */
public class NO_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int aValue = Integer.parseInt(st.nextToken());
            int bValue = Integer.parseInt(st.nextToken());
            int cValue = Integer.parseInt(st.nextToken());
            int dValue = Integer.parseInt(st.nextToken());

            a[i] = aValue;
            b[i] = bValue;
            c[i] = cValue;
            d[i] = dValue;
        }

        int size = n * n;
        long[] abSum = new long[size];
        long[] cdSum = new long[size];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long abSumValue = a[i] + b[j];
                long cdSumValue = c[i] + d[j];
                abSum[idx] = abSumValue;
                cdSum[idx] = cdSumValue;
                idx++;
            }
        }

        Arrays.sort(abSum);
        Arrays.sort(cdSum);

        long result = 0L;

        int left = 0;
        int right = size - 1;

        while (left < size && right >= 0) {
            Long leftVal = abSum[left];
            Long rightVal = cdSum[right];
            long sum = leftVal + rightVal;

            if (sum == 0) {
                long countAB = 0;
                while (left < size && abSum[left] == leftVal) {
                    countAB++;
                    left++;
                }

                long countCD = 0;
                while (right >= 0 && cdSum[right] == rightVal) {
                    countCD++;
                    right--;
                }

                result += countAB * countCD;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result);
    }
}
