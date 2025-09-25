import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_21939 {
    private static class Problem {
        int p;
        int l;

        private Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Problem> ts = new TreeSet<>(
                (o1, o2) -> {
                    if (o1.l == o2.l) {
                        return o1.p - o2.p;
                    }
                    return o1.l - o2.l;
                }
        );

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            ts.add(new Problem(p, l));
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());

                    ts.add(new Problem(p, l));
                    map.put(p, l);

                    break;
                case "recommend":
                    int level = Integer.parseInt(st.nextToken());

                    if (level == 1) {
                        System.out.println(ts.last().p);
                    } else {
                        System.out.println(ts.first().p);
                    }
                    
                    break;
                case "solved":
                    int number = Integer.parseInt(st.nextToken());
                    Integer solveLevel = map.get(number);

                    ts.remove(new Problem(number, solveLevel));
                    break;
                default:
                    break;
            }

        }
    }
}
