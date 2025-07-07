import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_1326 {
    static boolean[] visited;
    static int[] bridge;

    static class Position {
        int index;
        int jumpCount;

        public Position(int index, int jumpCount) {
            this.index = index;
            this.jumpCount = jumpCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        bridge = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, b));
    }

    public static int bfs(int start, int end) {
        if (start == end) {
            return 0;
        }

        int startIndex = start - 1;
        int endIndex = end - 1;

        Queue<Position> positionQueue = new LinkedList<>();
        positionQueue.add(new Position(startIndex, 0));
        visited[startIndex] = true;

        while (!positionQueue.isEmpty()) {
            Position position = positionQueue.poll();
            int currentIndex = position.index;
            int currentJumpCount = position.jumpCount;
            int jumpValue = bridge[currentIndex];

            // 오른쪽 점프
            for (int nextIndex = currentIndex + jumpValue; nextIndex < bridge.length; nextIndex += jumpValue) {

                if (nextIndex == endIndex) {
                    return currentJumpCount + 1;
                }

                if (!visited[nextIndex]) {
                    positionQueue.offer(new Position(nextIndex, currentJumpCount + 1));
                    visited[nextIndex] = true;
                }
            }

            // 왼쪽 점프
            for (int nextIndex = currentIndex - jumpValue; nextIndex >= 0; nextIndex -= jumpValue) {
                if (nextIndex == endIndex) {
                    return currentJumpCount + 1;
                }

                if (!visited[nextIndex]) {
                    positionQueue.offer(new Position(nextIndex, currentJumpCount + 1));
                    visited[nextIndex] = true;
                }
            }
        }

        return -1;
    }
}
