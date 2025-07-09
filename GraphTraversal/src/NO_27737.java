import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_27737 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        MushroomFarm mushroomFarm = new MushroomFarm(n, m, k);

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                mushroomFarm.setValue(row, col, Integer.parseInt(st.nextToken()));
            }
        }

        mushroomFarm.result();
    }

    static class MushroomFarm {
        private int[][] farm;
        private boolean[][] visited;
        private int spores;
        private int maxLink;
        private int[] dRow = {0, 1, 0, -1};
        private int[] dCol = {1, 0, -1, 0};

        public MushroomFarm(int n, int m, int k) {
            this.farm = new int[n][n];
            this.visited = new boolean[n][n];
            this.spores = m;
            this.maxLink = k;
        }

        public void setValue(int row, int col, int value) {
            this.farm[row][col] = value;
        }

        private boolean isValid(int row, int col) {
            return row >= 0 && col >= 0
                    && row < farm.length && col < farm.length
                    && canGrow(row, col);
        }

        private boolean canGrow(int row, int col) {
            return farm[row][col] == 0 && !visited[row][col];
        }

        private int findRegionSize(int row, int col) {
            visit(row, col);
            int regionSize = 1;

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];

                if (isValid(nextRow, nextCol)) {
                    regionSize += findRegionSize(nextRow, nextCol);
                }
            }

            return regionSize;
        }

        private void visit(int row, int col) {
            visited[row][col] = true;
        }

        public void result() {
            int originalSpores = spores;

            for (int row = 0; row < farm.length; row++) {
                for (int col = 0; col < farm.length; col++) {
                    if(canGrow(row, col)) {
                        int regionSize = findRegionSize(row, col);
                        int requiredSpores = (int) Math.ceil((double) regionSize / maxLink);
                        spores -= requiredSpores;
                    }
                }
            }

            if (spores == originalSpores) {
                System.out.println("IMPOSSIBLE");
            } else if (spores >= 0) {
                System.out.println("POSSIBLE");
                System.out.println(spores);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }


}
