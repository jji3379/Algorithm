import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }
            
            IslandMap islandMap = new IslandMap(w, h);

            for (int row = 0; row < h; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < w; col++) {
                    int value = Integer.parseInt(st.nextToken());
                    islandMap.setValue(row, col, value);
                }
            }

            System.out.println(islandMap.countIslands());
        }
    }

    static class IslandMap {
        private int[][] grid;
        private boolean[][] visited;
        private int width;
        private int height;
        private int[] dRow = {-1, 0, 1, 1, 1, 0, -1, -1};
        private int[] dCol = {1, 1, 1, 0, -1, -1, -1, 0};

        public IslandMap(int w, int h) {
            this.width = w;
            this.height = h;
            this.grid = new int[h][w];
            this.visited = new boolean[h][w];
        }

        public void setValue(int row, int col, int value) {
            this.grid[row][col] = value;
        }

        public boolean isValidPosition(int row, int col) {
            return row >= 0 && col >=0 && row < this.height && col < this.width;
        }

        public boolean isLand(int row, int col) {
            return grid[row][col] == 1;
        }

        public boolean isVisited(int row, int col) {
            return visited[row][col];
        }

        public void markVisited(int row, int col) {
            visited[row][col] = true;
        }

        public boolean canExplore(int row, int col) {
            return isValidPosition(row, col) && isLand(row, col) && !isVisited(row, col);
        }

        public void exploreIsland(int row, int col) {
            markVisited(row, col);

            for (int direction = 0; direction < 8; direction++) {
                int nextRow = row + dRow[direction];
                int nextCol = col + dCol[direction];
                
                if (canExplore(nextRow, nextCol)) {
                    exploreIsland(nextRow, nextCol);
                }
            }
        }
        
        public int countIslands() {
            int landCount = 0;

            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (canExplore(row, col)) {
                        exploreIsland(row, col);
                        landCount++;
                    }
                }
            }
            
            return landCount;
        }
    }
}
