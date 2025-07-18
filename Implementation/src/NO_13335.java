import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_13335 {
    static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> waitingList = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            waitingList.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Truck> movingList = new LinkedList<>();

        int time = 0;
        int weightSum = 0;

        while (!waitingList.isEmpty() || !movingList.isEmpty()) {
            time++;

            if (!movingList.isEmpty() && movingList.peek().isComplete()) {
                Truck completedTruck = movingList.poll();
                weightSum -= completedTruck.weight;
            }

            if (!waitingList.isEmpty()) {
                int nextTruckWeight = waitingList.peek();
                if (weightSum + nextTruckWeight <= L) {
                    int truckWeight = waitingList.poll();

                    movingList.offer(new Truck(truckWeight));
                    weightSum += truckWeight;
                }
            }

            for (Truck truck : movingList) {
                truck.move();
            }
        }

        System.out.println(time);
    }

    static class Truck {
        private int weight;
        private int position;

        public Truck(int weight) {
            this.weight = weight;
            this.position = 1;
        }

        public int move() {
            return position++;
        };

        public boolean isComplete() {
            return position > w;
        }
    }
}
