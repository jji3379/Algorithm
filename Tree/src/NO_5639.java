import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_5639 {
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            // 왼쪽 노드
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new Node(value);
                } else {
                    this.left.insert(value);
                }
            } else { // 오른쪽 노드
                if (this.right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.insert(value);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Node root = new Node(Integer.parseInt(st.nextToken()));

        while (true) {
            String value = br.readLine();
            if (value == null || "".equals(value)) {
                break;
            }

            root.insert(Integer.parseInt(value));
        }

        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }
}
