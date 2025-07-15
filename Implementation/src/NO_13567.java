import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_13567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;
        int dir = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (command.equals("TURN")) {
                if (value == 0) {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
            } else {
                int nx = x + dx[dir] * value;
                int ny = y + dy[dir] * value;

                if (nx < 0 || ny < 0 || nx > m || ny > m) {
                    System.out.println("-1");
                    return;
                }

                x = nx;
                y = ny;
            }
        }

        System.out.println(x + " " + y);
    }
}
