import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16926
 */
public class NO_16926 {
    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int space = Math.min(n, m) / 2;

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            rotate(space);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int space) {
        int[][] rotateArr = new int[n][m];
        for (int i = 0; i < space; i++) {
            // 밑으로 회전
            for (int j = i; j < n - 1 - i; j++) {
                rotateArr[j + 1][i] = arr[j][i];
            }

            // 오른쪽 회전
            for (int j = i; j < m - 1 - i; j++) {
                rotateArr[n - 1 - i][j + 1] = arr[n - 1 - i][j];
            }

            // 위로 회전
            for (int j = n - 1 - i; j > 0 + i; j--) {
                rotateArr[j - 1][m - 1 - i] = arr[j][m - 1 - i];
            }

            // 왼쪽 회전
            for (int j = m - 1 - i; j > 0 + i; j--) {
                rotateArr[i][j - 1] = arr[i][j];
            }
        }

        arr = rotateArr;
    }
}
