import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO_10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        RGBGrid rgbGrid = new RGBGrid(n);

        for (int row = 0; row < n; row++) {
            String line = br.readLine();
            for (int col = 0; col < n; col++) {
                rgbGrid.setValue(row, col, line.charAt(col));
            }
        }

        rgbGrid.result();
    }

    public static class RGBGrid {
        private char[][] grid;
        private boolean[][] visited;
        private int[] dRow = {0, 1, 0, -1};
        private int[] dCol = {1, 0, -1, 0};

        public RGBGrid(int n) {
            this.grid = new char[n][n];
            this.visited = new boolean[n][n];
        }

        public void setValue(int row, int col, char value) {
            this.grid[row][col] = value;
        }

        private boolean isValid(int row, int col) {
            return row >= 0 && col >= 0 &&
                    row < grid.length && col < grid.length &&
                    canVisit(row, col);
        }

        private boolean canVisit(int row, int col) {
            return !visited[row][col];
        }

        private void visit(int row, int col) {
            visited[row][col] = true;
        }

        private boolean isEqualColor(char currentColor, char nextColor) {
            return currentColor == nextColor;
        }

        private void findRegion(int row, int col) {
            visit(row, col);

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];

                if (isValid(nextRow, nextCol)) {
                    char currentColor = grid[row][col];
                    char nextColor = grid[nextRow][nextCol];

                    if (isEqualColor(currentColor, nextColor)) {
                        findRegion(nextRow, nextCol);
                    }
                }
            }
        }

        private void findBlindRegion(int row, int col) {
            visit(row, col);

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];

                if (isValid(nextRow, nextCol)) {
                    char currentColor = grid[row][col];
                    char nextColor = grid[nextRow][nextCol];

                    if (isBlindColor(currentColor, nextColor)) {
                        findBlindRegion(nextRow, nextCol);
                    }
                }
            }
        }

        private boolean isBlindColor(char currentColor, char nextColor) {
            if (isEqualColor(currentColor, nextColor)) {
                return true;
            }

            return currentColor != 'B' && nextColor != 'B';
        }

        private int getBlindRegionCount() {
            visited = new boolean[grid.length][grid.length];
            int blindRegion = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (canVisit(i, j)) {
                        findBlindRegion(i, j);
                        blindRegion++;
                    }
                }
            }

            return blindRegion;
        }

        private int getNormalRegionCount() {
            visited = new boolean[grid.length][grid.length];
            int region = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if(canVisit(i, j)) {
                        findRegion(i, j);
                        region++;
                    }
                }
            }

            return region;
        }

        public void result() {
            int region = getNormalRegionCount();
            int blindRegion = getBlindRegionCount();

            System.out.print(region + " " + blindRegion);
        }

    }
}
