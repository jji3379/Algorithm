import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/20442
 */
public class NO_20442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] inputArr = input.toCharArray();

        int rCnt = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == 'R') {
                rCnt++;
            }
        }

        int max = rCnt;
        int left = 0;
        int right = inputArr.length - 1;
        int leftKCnt = 0;
        int rightKCnt = 0;

        while(left <= right) {
            if (leftKCnt < rightKCnt) {
                if (inputArr[left++] == 'R') {
                    max = Math.max(max, Math.min(leftKCnt, rightKCnt) * 2 + rCnt--);
                } else {
                    leftKCnt++;
                }
            } else {
                if (inputArr[right--] == 'R') {
                    max = Math.max(max, Math.min(leftKCnt, rightKCnt) * 2 + rCnt--);
                } else {
                    rightKCnt++;
                }
            }
        }

        System.out.println(max);
    }
}
