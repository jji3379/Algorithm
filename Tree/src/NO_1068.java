import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_1068 {
    private static class Node {
        private int root;
        private List<Integer> leaf;

        private Node(int root) {
            this.root = root;
            this.leaf = new ArrayList<>();
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int root = Integer.MIN_VALUE;

        Node[] tree = new Node[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // i 의 값이 노드의 번호임
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            // search 의 시작위치인 루트의 위치를 알아야 하기에 root 값 체크
            if (parent == -1) {
                root = i;
            }

            // 각 정점들 생성
            tree[i] = new Node(parent);
        }

        for (int i = 0; i < n; i++) {
            // root 는 parent 가 없으니까
            if (root != i) {
                // 1번 트리의 루트를 찾아.
                int parent = tree[i].root;

                // 루트에 자식 추가해주기
                tree[parent].leaf.add(i);
            }
        }

        int removeIndex = Integer.parseInt(br.readLine());

        if (removeIndex == root) {
            System.out.println(0);
        } else {
            // 해당 노드를 지우려면 부모에서 자식을 지워야함.
            int parent = tree[removeIndex].root;
            // Integer.valueOf 로 특정 값 삭제
            tree[parent].leaf.remove(Integer.valueOf(removeIndex));

            int result = dfs(tree, root);
            System.out.println(result);
        }
    }

    private static int dfs(Node[] tree, int root) {
        List<Integer> leaf = tree[root].leaf;

        if (leaf.isEmpty()) {
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < leaf.size(); i++) {
            sum += dfs(tree, leaf.get(i));
        }

        return sum;
    }
}
