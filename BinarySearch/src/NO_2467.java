import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;
        long minSum = Long.MAX_VALUE;

        int leftResult = 0;
        int rightResult = 0;

        while (left < right) {
            long tempSum = arr[left] + arr[right];
            if (Math.abs(tempSum) < minSum) {
                minSum = Math.abs(tempSum);
                leftResult = left;
                rightResult = right;
            }
            if (tempSum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(arr[leftResult] + " " + arr[rightResult]);
    }
}
