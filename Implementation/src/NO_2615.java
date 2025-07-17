import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_2615 {
    static int[][] board = new int[21][21];
    static int[] dRow = {1, 1, 0, -1};
    static int[] dCol = {0, 1, 1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int row = 1; row <= 19; row++) {
            for (int col = 1; col <= 19; col++) {
                if (board[row][col] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        if (checkWin(row, col, dir)) {
                            System.out.println(board[row][col]);
                            System.out.println(row + " " + col);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static boolean checkWin(int row, int col, int dir) {
        int color = board[row][col];

        if (!isStartPosition(row, col, dir, color)) {
            return false;
        }

        int count = 1;
        int nRow = row + dRow[dir];
        int nCol = col + dCol[dir];

        while (isValid(nRow, nCol) && board[nRow][nCol] == color) {
            count++;

            if (count > 5) {
                return false;
            }

            nRow += dRow[dir];
            nCol += dCol[dir];
        }

        return count == 5;
    }

    private static boolean isStartPosition(int row, int col, int dir, int color) {
        int prevRow = row - dRow[dir];
        int prevCol = col - dCol[dir];

        return isValid(prevRow, prevCol) && board[prevRow][prevCol] != color;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < 21 && col >= 0 && col < 21;
    }
}