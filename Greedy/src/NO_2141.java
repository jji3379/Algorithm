import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2141
 */
public class NO_2141 {
    private static class House implements Comparable<House> {
        private long index, count;

        private House(long index, long count) {
            this.index = index;
            this.count = count;
        }

        public int compareTo(House h) {
            return Long.compare(this.index, h.index);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<House> houses = new ArrayList<>();

        Long totalCount = 0L;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            House house = new House(index, count);
            houses.add(house);
            totalCount += count;
        }

        Collections.sort(houses);

        Long result = 0L;
        for (int i = 0; i < n; i++) {
            House house = houses.get(i);

            result += house.count;
            if ((totalCount + 1) / 2 <= result) {
                System.out.print(house.index + " ");
                break;
            }
        }
    }
}
