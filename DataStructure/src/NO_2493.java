import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NO_2493 {
    static class Node {
        int index;
        int height;

        public Node(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek().height >= arr[i]) {
                    System.out.print(stack.peek().index + " ");
                    break;
                }

                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print(0 + " ");
            }

            stack.push(new Node(i + 1, arr[i]));
        }

    }
}
