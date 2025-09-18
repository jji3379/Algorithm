import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_22942 {
    private static class Circle {
        private int index;
        private int point;

        public Circle(int index, int point) {
            this.index = index;
            this.point = point;
        }
    }

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        List<Circle> circles = new ArrayList();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            circles.add(new Circle(i, x - d));
            circles.add(new Circle(i, x + d));
        }

        circles.sort(Comparator.comparing(o -> o.point));

        System.out.println(printResult(circles));
    }

    private static String printResult(List<Circle> circles) {
        Stack<Circle> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for (Circle circle : circles) {
            int index = circle.index;

            if (!visited[index]) {
                visited[index] = true;
                stack.push(circle);
            } else {
                Circle pop = stack.pop();
                if (index != pop.index) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}
